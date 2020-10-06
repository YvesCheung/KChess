package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameBoard
import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.TestOnly

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
class GoBangGameBoard : GameBoard<Pieces>() {

    init {
        reset()
    }

    var rowSize: Int = DEFAULT_SIZE
        private set

    var columnSize: Int = DEFAULT_SIZE
        private set

    override fun reset() = reset(DEFAULT_SIZE, DEFAULT_SIZE)

    internal fun reset(rowSize: Int, columnSize: Int) {
        if (rowSize <= 0 || columnSize <= 0) {
            throw IllegalArgumentException("Can't reset a gameBoard with row($rowSize) and column($columnSize)")
        }
        this.rowSize = rowSize
        this.columnSize = columnSize
        gameBoard = Array(rowSize) { arrayOfNulls<Pieces?>(columnSize) }
    }

    @TestOnly
    override fun reset(board: Array<Array<Pieces?>>) {
        this.rowSize = board.size
        this.columnSize = board.first().size
        super.reset(board)
    }

    override fun contains(row: Int, column: Int): Boolean {
        return row in 0 until rowSize && column in 0 until columnSize
    }

    override fun toString(): String {

        fun piece(c: Pieces) =
            "--${if (c belongsTo OwnerShip.Player1) "O" else "X"}--"

        fun noPiece() = "--+--"

        val s = StringBuilder()
        forEach { (piece, row, column) ->
            if (row != 0 && column == 0) {
                s.append('\n')
                s.append('\n')
            }
            if (piece != null) s.append(piece(piece)) else s.append(noPiece())
        }
        s.append('\n')
        return s.toString()
    }

    companion object {
        const val DEFAULT_SIZE = 15
    }
}
