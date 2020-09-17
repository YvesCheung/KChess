package com.github.kchess.algorithm

import com.github.kchess.algorithm.ChineseChessBoard.Companion.COLUMN_SIZE
import com.github.kchess.algorithm.ChineseChessBoard.Companion.ROW_SIZE

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearch : GameActionSearch<ChineseChess>() {

    private val evaluator = ChessmanEvaluator.createFactory()

    override fun evaluate(context: ChineseChess, player: OwnerShip): Int {
        var value = 0
        context.gameBroad.forEach { (chessman, r, c) ->
            val evaluate =
                if (!player) {
                    evaluator(chessman).valueMap[ROW_SIZE - r - 1][COLUMN_SIZE - c - 1]
                } else {
                    evaluator(chessman).valueMap[r][c]
                }
            if (chessman.owner != player) {
                value -= evaluate
            } else {
                value += evaluate
            }
        }
        return value
    }

    private val rule = ChessmanRule.createFactory()

    override fun nextMove(context: ChineseChess, player: OwnerShip): Sequence<GameAction<ChineseChess>> {
        return sequence {
            context.gameBroad.forEach { (chessman, row, column) ->
                if (chessman.owner == player) {
                    yieldAll(
                        rule(chessman).nextMove(row, column, context).map { (newRow, newColumn) ->
                            ChineseChessAction(chessman, row, column, newRow, newColumn)
                        }
                    )
                }
            }
        }
    }
}
