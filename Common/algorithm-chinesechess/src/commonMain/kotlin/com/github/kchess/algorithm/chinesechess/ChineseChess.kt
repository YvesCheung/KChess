package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.*
import com.github.kchess.algorithm.chinesechess.ChineseChessEvaluator.Companion.DEAD_VALUE
import com.github.kchess.algorithm.util.ObservableList
import com.github.kchess.algorithm.Position
import kotlin.js.JsName
import kotlin.math.abs

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChess : Game() {

    private val moveSearch = ChineseChessSearch()

    private val actionRecord =
        ObservableList<GameAction<ChineseChess>> { actionList ->
            listeners["record"]?.forEach { callback -> callback(actionList.toTypedArray()) }
        }

    /**
     * 棋盘
     */
    val gameBoard = ChineseChessBoard()

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
        if (gameOver) return

        val (maxDepth, thinkingTime) =
            when (actionRecord.size) {
                in 0..6 -> 4 to 5 * 1000L
                in 7..16 -> 5 to 10 * 1000L
                in 16..30 -> 6 to 10 * 1000L
                else -> 6 to 15 * 1000L
            }
        val result =
            moveSearch.alphaBetaSearchWithTimeout(this, player, 4, maxDepth, thinkingTime)
        val action = result.action
        if (action != null) {
            takeAction(action, player)
        }
    }

    private fun takeAction(action: GameAction<ChineseChess>, player: OwnerShip) {
        if (gameOver) return

        action.run(this)
        actionRecord.add(action)
        currentPlayer = -player

        val checkGameOver =
            moveSearch.alphaBetaSearch(2, this, currentPlayer)
        if (abs(checkGameOver.evaluateValue) > DEAD_VALUE) {
            gameOver = true
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
            val action = actionRecord.removeLast()
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
    fun actionRecord(): List<GameAction<ChineseChess>> = actionRecord.toList()

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
        gameOver = false

        listeners["reset"]?.forEach { callback -> callback(emptyArray()) }
    }
}
