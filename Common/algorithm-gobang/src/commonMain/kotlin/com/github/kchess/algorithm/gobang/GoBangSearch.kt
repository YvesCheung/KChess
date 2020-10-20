package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBangSearch : GameActionSearch<Pieces, GoBang>() {

    override fun evaluate(context: GoBang, player: OwnerShip): Int {
        return GoBangEvaluator.evaluate(context, player)
    }

    override fun nextMove(context: GoBang, depth: Int, player: OwnerShip): Sequence<GameAction<Pieces>> {
        return sequence {
            tryStruggleMiddlePoint(context, player)
            context.gameBoard.forEach { (piece, row, column) ->
                if (piece == null && hasAdjoiningPiece(context, row, column)) {
                    yield(GoBangAction(Pieces.of(player), row, column))
                }
            }
        }
    }

    private suspend fun SequenceScope<GoBangAction>.tryStruggleMiddlePoint(context: GoBang, player: OwnerShip) {
        val mr = context.gameBoard.rowSize shr 1
        val mc = context.gameBoard.columnSize shr 1
        if (context.gameBoard[mr, mc] == null) {
            yield(GoBangAction(Pieces.of(player), mr, mc))
        }
    }

    private fun hasAdjoiningPiece(context: GoBang, row: Int, column: Int): Boolean {
        return context.gameBoard[row - 1, column] != null ||
            context.gameBoard[row - 1, column - 1] != null ||
            context.gameBoard[row, column - 1] != null ||
            context.gameBoard[row + 1, column] != null ||
            context.gameBoard[row - 1, column + 1] != null ||
            context.gameBoard[row + 1, column + 1] != null ||
            context.gameBoard[row + 1, column - 1] != null ||
            context.gameBoard[row, column + 1] != null
    }
}
