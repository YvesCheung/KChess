package com.github.kchess.algorithm

import com.github.kchess.algorithm.ChessmanEvaluator.Companion.DEAD_VALUE
import kotlin.js.JsName
import kotlin.math.abs

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChess {

    private val moveSearch = ChineseChessSearch()

    private val actionRecord = mutableListOf<GameAction<ChineseChess>>()

    private val listeners: Map<String, MutableList<(param: Array<Any>) -> Unit>> =
        listOf("reset", "over").associateWith {
            @Suppress("RemoveExplicitTypeArguments")
            mutableListOf<(param: Array<Any>) -> Unit>()
        }

    /**
     * 棋盘
     */
    val gameBoard = ChineseChessBoard()

    /**
     * 当前可行动的玩家
     */
    var currentPlayer: OwnerShip = OwnerShip.Player1
        private set

    /**
     * 进行一次棋子移动
     *
     * @param action 棋子移动
     * @param player 回合行动的玩家
     */
    @JsName("move")
    fun move(action: GameAction<ChineseChess>, player: OwnerShip = currentPlayer) {
        takeAction(action, player)
    }

    /**
     * 进行一次机器人的自动移动
     *
     * @param player 回合行动的玩家
     */
    @JsName("autoMove")
    fun autoMove(player: OwnerShip = currentPlayer) {
        val result =
            moveSearch.alphaBetaSearch(4, this, player)
        val action = result.action
        if (action != null) {
            takeAction(action, player)
        }
    }

    private fun takeAction(action: GameAction<ChineseChess>, player: OwnerShip) {
        action.run(this)
        actionRecord.add(action)
        currentPlayer = -player

        val checkGameOver =
            moveSearch.alphaBetaSearch(2, this, currentPlayer)
        if (abs(checkGameOver.evaluateValue) > DEAD_VALUE) {
            listeners["over"]?.forEach { callback -> callback(arrayOf(player)) }
        }
    }

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
            val action =
                actionRecord.removeAt(actionRecord.lastIndex)
            action.undo(this)
            currentPlayer = -currentPlayer
        }
    }

    /**
     * 获取目标棋子当前可以移动的坐标
     *
     * @param row 目标棋子所在行数
     * @param column 目标棋子所在的列数
     */
    @JsName("getIntentAction")
    fun getIntentAction(row: Int, column: Int): List<Position> {
        val chessman = this.gameBoard[row, column]
        if (chessman != null) {
            return ChessmanRule.nextMove(chessman, row, column, this).toList()
        }
        return emptyList()
    }

    @JsName("record")
    fun actionRecord(): List<GameAction<ChineseChess>> = actionRecord

    /**
     * 重置游戏
     */
    @JsName("reset")
    fun reset(board: Array<Array<Chessman?>>? = null) {
        if (board == null) {
            gameBoard.reset()
        } else {
            gameBoard.reset(board)
        }
        currentPlayer = OwnerShip.Player1
        actionRecord.clear()

        listeners["reset"]?.forEach { callback -> callback(emptyArray()) }
    }

    /**
     * 添加事件监听
     *
     * ```
     * addEventListener("over", (winner)=>{})
     * addEventListener("reset", ()=>{})
     * ```
     */
    @JsName("addEventListener")
    fun addEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.add(callback)
    }

    /**
     * @see addEventListener
     */
    @JsName("removeEventListener")
    fun removeEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.remove(callback)
    }
}


data class Position(val row: Int, val column: Int) {

    fun offset(offset: Position): Position = Position(row + offset.row, column + offset.column)
}
