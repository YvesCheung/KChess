package com.github.kchess.algorithm

import com.github.kchess.algorithm.ChineseChessBoard.COLUMN_SIZE
import com.github.kchess.algorithm.ChineseChessBoard.ROW_SIZE

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearch : GameActionSearch<ChineseChess>() {

    private val evaluator = ChessmanEvaluator.createFactory()

    override fun evaluate(context: ChineseChess): Int {
        var value = 0
        context.gameBroad.forEachIndexed { x, row ->
            row.forEachIndexed { y, chessman ->
                if (chessman != null) {
                    value += evaluator(chessman).valueMap[x][y]
                }
            }
        }
        return value
    }

    private val rule = ChessmanRule.createFactory()

    override fun nextMove(context: ChineseChess, simulateTurn: Boolean): Sequence<GameAction<ChineseChess>> {
        return sequence {
            context.gameBroad.forEachIndexed { x, row ->
                row.forEachIndexed { y, chessman ->
                    if (chessman != null && chessman.redTurn == simulateTurn) {
                        yieldAll(
                            rule(chessman).nextMove(Position(x, y), context, chessman.redTurn)
                                .mapNotNull { (newX, newY) ->
                                    if (newX in 0 until ROW_SIZE &&
                                        newY in 0 until COLUMN_SIZE &&
                                        (x != newX || y != newY) &&
                                        context.gameBroad[newX][newY]?.redTurn != chessman.redTurn
                                    ) {
                                        ChineseChessAction(chessman, x, y, newX, newY)
                                    } else {
                                        null
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}
