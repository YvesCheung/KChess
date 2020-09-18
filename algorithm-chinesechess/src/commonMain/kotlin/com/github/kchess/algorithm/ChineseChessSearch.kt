package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearch : GameActionSearch<ChineseChess>() {

    override fun evaluate(context: ChineseChess, player: OwnerShip): Int {
        return context.gameBroad.fold(0) { value, (chessman, row, column) ->
            value + ChessmanEvaluator.evaluate(chessman, row, column, player)
        }
    }

    override fun nextMove(context: ChineseChess, player: OwnerShip): Sequence<GameAction<ChineseChess>> {
        return sequence {
            context.gameBroad.forEach { (chessman, row, column) ->
                if (chessman.owner == player) {
                    yieldAll(
                        ChessmanRule.nextMove(chessman, row, column, context).map { (newRow, newColumn) ->
                            ChineseChessAction(chessman, row, column, newRow, newColumn)
                        }
                    )
                }
            }
        }
    }
}
