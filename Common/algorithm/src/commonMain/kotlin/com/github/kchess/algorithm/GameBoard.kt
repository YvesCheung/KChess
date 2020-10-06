package com.github.kchess.algorithm

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/30
 */
abstract class GameBoard<GamePiece : Any> : Iterable<GamePieceWithPosition<GamePiece>> {

    protected lateinit var gameBoard: Array<Array<GamePiece?>>

    override fun iterator(): Iterator<GamePieceWithPosition<GamePiece>> {
        return iterator {
            gameBoard.forEachIndexed { r, row ->
                row.forEachIndexed { c, chessman ->
                    if (chessman != null) {
                        yield(GamePieceWithPosition(chessman, r, c))
                    }
                }
            }
        }
    }

    @JsName("forEach")
    fun forEachNullable(yield: (element: GamePiece?, newLine: Boolean, row: Int, column: Int) -> Unit) {
        var newLine = false
        gameBoard.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, chessman ->
                yield(chessman, newLine, rowIndex, columnIndex)
                newLine = false
            }
            newLine = true
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
}
