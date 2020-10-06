package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.Game
import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.Position
import com.github.kchess.algorithm.chinesechess.ChineseChessEvaluator.Companion.DEAD_VALUE
import kotlin.js.JsName
import kotlin.math.abs

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChess : Game<Chessman>() {

    /**
     * 棋盘
     */
    override val gameBoard = ChineseChessBoard()

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

    override val autoSearch = ChineseChessSearch()

    override fun autoMoveAction(player: OwnerShip): GameAction<Chessman>? {
        val (maxDepth, thinkingTime) =
            when (actionRecord.size) {
                in 0..6 -> 4 to 5 * 1000L
                in 7..16 -> 5 to 10 * 1000L
                in 16..30 -> 6 to 10 * 1000L
                else -> 6 to 15 * 1000L
            }
        val result =
            autoSearch.alphaBetaSearchWithTimeout(this, player, 4, maxDepth, thinkingTime)
        return result.action
    }

    override fun checkGameOver(): Boolean {
        val checkGameOver =
            autoSearch.alphaBetaSearch(2, this, currentPlayer)
        return abs(checkGameOver.evaluateValue) > DEAD_VALUE
    }
}
