package com.github.kchess.algorithm

import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("unused")
abstract class GameBoard<GamePiece : Any> : Iterable<GamePieceWithPosition<GamePiece?>> {

    protected lateinit var gameBoard: Array<Array<GamePiece?>>

    abstract fun reset()

    open fun reset(board: Array<Array<GamePiece?>>) {
        gameBoard = board
    }

    override fun iterator(): Iterator<GamePieceWithPosition<GamePiece?>> {
        return iterator {
            gameBoard.forEachIndexed { rowIndex, row ->
                row.forEachIndexed { columnIndex, chessman ->
                    yield(GamePieceWithPosition(chessman, rowIndex, columnIndex))
                }
            }
        }
    }

    @JsName("forEach")
    fun forEachJs(yield: (element: GamePiece?, row: Int, column: Int) -> Unit) {
        forEach { (chessman, rowIndex, columnIndex) ->
            yield(chessman, rowIndex, columnIndex)
        }
    }

    @JsName("contains")
    open fun contains(row: Int, column: Int): Boolean =
        row in gameBoard.indices && column in gameBoard.first().indices

    operator fun contains(pos: Position): Boolean = contains(pos.row, pos.column)

    @JsName("get")
    open operator fun get(row: Int, column: Int): GamePiece? {
        if (contains(row, column)) return gameBoard[row][column]
        return null
    }

    operator fun get(position: Position): GamePiece? =
        get(position.row, position.column)

    open operator fun set(row: Int, column: Int, chessman: GamePiece?) {
        if (contains(row, column)) {
            gameBoard[row][column] = chessman
        }
    }

    operator fun set(pos: Position, chessman: GamePiece?) =
        set(pos.row, pos.column, chessman)

    override fun equals(other: Any?): Boolean {
        if (other is Iterable<*>) {
            val a = iterator()
            val b = other.iterator()
            while (a.hasNext() && b.hasNext()) {
                if (a.next() != b.next()) {
                    return false
                }
            }
            if (!a.hasNext() && !b.hasNext()) return true
        }
        return false
    }

    override fun hashCode(): Int = gameBoard.hashCode()
}
