package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearch : GameActionSearch<ChineseChess>() {

    override fun evaluate(context: ChineseChess, player: OwnerShip): Int {
        return context.gameBoard.fold(0) { value, (chessman, row, column) ->
            value + ChineseChessEvaluator.evaluate(chessman, row, column, player)
        }
    }

    override fun nextMove(context: ChineseChess, player: OwnerShip): Sequence<GameAction<ChineseChess>> {
        return sequence {
            context.gameBoard.forEach { (chessman, row, column) ->
                if (chessman.owner == player) {
                    yieldAll(
                        ChessmanRule.nextMove(chessman, row, column, context).map { (newRow, newColumn) ->
                            ChineseChessAction(
                                chessman,
                                row,
                                column,
                                newRow,
                                newColumn
                            )
                        }
                    )
                }
            }
        }
    }
}
