package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/25
 */
data class Position(val row: Int, val column: Int) {

    fun offset(offset: Position): Position = Position(row + offset.row, column + offset.column)
}
