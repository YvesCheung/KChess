package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameBoard

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
class GoBangGameBoard : GameBoard<Pieces>() {

    var rowSize: Int = DEFAULT_SIZE
        private set

    var columnSize: Int = DEFAULT_SIZE
        private set

    init {
        reset()
    }

    internal fun reset(size: Int = DEFAULT_SIZE) = reset(size, size)

    internal fun reset(rowSize: Int, columnSize: Int) {
        if (rowSize <= 0 || columnSize <= 0) {
            throw IllegalArgumentException("Can't reset a gameBoard with row($rowSize) and column($columnSize)")
        }
        this.rowSize = rowSize
        this.columnSize = columnSize
        gameBoard = Array(rowSize) { arrayOfNulls(columnSize) }
    }

    override fun contains(row: Int, column: Int): Boolean {
        return row in 0 until rowSize && column in 0 until columnSize
    }

    companion object {
        const val DEFAULT_SIZE = 10
    }
}
