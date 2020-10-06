package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.Game
import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.OwnerShip.Player1
import com.github.kchess.algorithm.OwnerShip.Player2
import com.github.kchess.algorithm.chinesechess.Chessman.红将
import com.github.kchess.algorithm.chinesechess.Chessman.黑帅


/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearch : GameActionSearch<Chessman, ChineseChess>() {

    override fun evaluate(context: ChineseChess, player: OwnerShip): Int {
        return context.gameBoard.fold(0) { value, (chessman, _, row, column) ->
            if (chessman != null) {
                value + ChineseChessEvaluator.evaluate(chessman, row, column, player)
            } else {
                value
            }
        }
    }

    override fun nextMove(context: ChineseChess, depth: Int, player: OwnerShip): Sequence<GameAction<Chessman>> {
        return sequence {
            context.gameBoard.forEach { (chessman, _, row, column) ->
                if (chessman != null && chessman.owner == player) {
                    yieldAll(
                        ChessmanRule.nextMove(chessman, row, column, context)
                            .map { (newRow, newColumn) ->
                                ChineseChessAction(chessman, row, column, newRow, newColumn)
                            }
                            .filter { action -> validate(depth, context, action) }
                    )
                }
            }
        }
    }

    private fun validate(depth: Int, context: Game<Chessman>, action: ChineseChessAction): Boolean {
        if (depth > 1) { //Just evaluate while depth <= 1, let it pass.
            val eat = context.gameBoard[action.newRow, action.newColumn]
            if ((context.currentPlayer == Player1 && eat == 红将) ||
                (context.currentPlayer == Player2 && eat == 黑帅)) { //It would kill itself, don't do this!
                return false
            }
        }
        return true
    }
}
