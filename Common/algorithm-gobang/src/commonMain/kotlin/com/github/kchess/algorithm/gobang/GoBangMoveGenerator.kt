package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.Position

/**
 * @author YvesCheung
 * 2020/10/20
 */
object GoBangMoveGenerator {

    fun nextMove(context: GoBang): Sequence<Position> {
        @Suppress("RemoveExplicitTypeArguments")
        return sequence<Position> {
            tryStruggleMiddlePoint(context)
            context.gameBoard.forEach { (piece, row, column) ->
                if (piece == null && hasAdjoiningPiece(context, row, column)) {
                    yield(Position(row, column))
                }
            }
        }.distinct()
    }

    private suspend fun SequenceScope<Position>.tryStruggleMiddlePoint(context: GoBang) {
        val mr = context.gameBoard.rowSize shr 1
        val mc = context.gameBoard.columnSize shr 1
        if (context.gameBoard[mr, mc] == null) {
            yield(Position(mr, mc))
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
