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

    override fun nextMove(context: ChineseChess, simulateTurn: Boolean): Iterable<GameAction<ChineseChess>> {
        val result = mutableListOf<GameAction<ChineseChess>>()
        context.gameBroad.forEachIndexed { x, row ->
            row.forEachIndexed { y, chessman ->
                if (chessman != null && chessman.redTurn == simulateTurn) {
                    chessman.nextMove(Position(x, y)).forEach { (newX, newY) ->
                        if (newX in 0 until ROW_SIZE &&
                            newY in 0 until COLUMN_SIZE
                        ) {
                            result.add(ChineseChessAction(chessman, x, y, newX, newY))
                        }
                    }
                }
            }
        }
        return result
    }
}
