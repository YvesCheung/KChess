package com.github.kchess.algorithm

import com.github.kchess.algorithm.util.ObservableList
import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class Game<Piece : Any> {

    /**
     * AI algorithm
     */
    protected abstract val autoSearch: GameActionSearch<Piece, out Game<Piece>>

    /**
     * 棋盘
     */
    abstract val gameBoard: GameBoard<Piece>

    /**
     * 下子记录
     */
    protected open val actionRecord = ObservableList<GameAction<Piece>> { actionList ->
        listeners["record"]?.forEach { callback -> callback(actionList.toTypedArray()) }
    }

    /**
     * 是否结束本局博弈
     */
    protected var gameOver = false

    protected open val listeners: Map<String, MutableList<(param: Array<Any>) -> Unit>> =
        listOf("reset", "over", "record").associateWith {
            @Suppress("RemoveExplicitTypeArguments")
            mutableListOf<(param: Array<Any>) -> Unit>()
        }

    /**
     * 当前可行动的玩家
     */
    @JsName("currentPlayer")
    var currentPlayer: OwnerShip = OwnerShip.Player1
        protected set

    /**
     * 是否已结束，无法再操作
     */
    @JsName("isGameOver")
    open fun isGameOver(): Boolean = gameOver

    /**
     * 进行一次棋子移动
     *
     * @param action 棋子移动
     * @param player 回合行动的玩家
     */
    @JsName("move")
    fun move(action: GameAction<Piece>, player: OwnerShip = currentPlayer) {
        takeAction(action, player)
    }

    /**
     * 进行一次机器人的自动移动
     *
     * @param player 回合行动的玩家
     */
    @JsName("autoMove")
    open fun autoMove(player: OwnerShip = currentPlayer) {
        if (gameOver) return

        val action = autoMoveAction(player)
        if (action != null) {
            takeAction(action, player)
        }
    }

    protected abstract fun autoMoveAction(player: OwnerShip): GameAction<Piece>?

    protected open fun takeAction(action: GameAction<Piece>, player: OwnerShip) {
        if (gameOver) return

        action.run(this)
        actionRecord.add(action)
        currentPlayer = -player

        if (checkGameOver()) {
            gameOver = true
            listeners["over"]?.forEach { callback -> callback(arrayOf(player)) }
        }
    }

    protected abstract fun checkGameOver(): Boolean

    /**
     * 悔棋
     *
     * @param recoverStep 回退步数
     */
    @JsName("regret")
    fun regret(recoverStep: Int = 2) {
        var step = recoverStep
        while (step-- > 0) {
            if (actionRecord.isEmpty()) {
                return
            }
            val action = actionRecord.removeLast()
            action.undo(this)
            currentPlayer = -currentPlayer
        }
    }

    /**
     * 重置游戏
     */
    @JsName("reset")
    fun reset(@TestOnly board: Array<Array<Piece?>>? = null) {
        if (board == null) {
            gameBoard.reset()
        } else {
            gameBoard.reset(board)
        }
        currentPlayer = OwnerShip.Player1
        actionRecord.clear()
        gameOver = false

        listeners["reset"]?.forEach { callback -> callback(emptyArray()) }
    }

    @JsName("record")
    fun actionRecord(): List<GameAction<Piece>> = actionRecord.toList()

    /**
     * 添加事件监听
     *
     * ```
     * addEventListener("over", ([winner])=>{})
     * addEventListener("reset", ()=>{})
     * addEventListener("record", (Array<action>)=>{})
     * ```
     */
    @JsName("addEventListener")
    open fun addEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.add(callback)
    }

    /**
     * @see addEventListener
     */
    @JsName("removeEventListener")
    open fun removeEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.remove(callback)
    }
}
