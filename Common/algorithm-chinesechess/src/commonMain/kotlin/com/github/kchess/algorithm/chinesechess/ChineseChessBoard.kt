package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.Position
import com.github.kchess.algorithm.chinesechess.Chessman.*
import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChessBoard : Iterable<ChessmanWithPosition> {

    private lateinit var gameBoard: Array<Array<Chessman?>>

    init {
        reset()
    }

    /**
     * [ROW_SIZE] * [COLUMN_SIZE]
     */
    internal fun reset() {
        @Suppress("RemoveExplicitTypeArguments")
        gameBoard = arrayOf<Array<Chessman?>>(
            arrayOf(黑车, 黑马, 黑象, 黑士, 黑帅, 黑士, 黑象, 黑马, 黑车),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(null, 黑炮, null, null, null, null, null, 黑炮, null),
            arrayOf(黑卒, null, 黑卒, null, 黑卒, null, 黑卒, null, 黑卒),
            arrayOf(null, null, null, null, null, null, null, null, null),

            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(红兵, null, 红兵, null, 红兵, null, 红兵, null, 红兵),
            arrayOf(null, 红炮, null, null, null, null, null, 红炮, null),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(红车, 红马, 红象, 红士, 红将, 红士, 红象, 红马, 红车)
        )
    }

    internal fun reset(board: Array<Array<Chessman?>>) {
        if (board.size != ROW_SIZE) {
            throw IllegalArgumentException("board.size must be $ROW_SIZE")
        }
        board.forEachIndexed { index, row ->
            if (row.size != COLUMN_SIZE) {
                throw IllegalArgumentException("board[$index].size must be $COLUMN_SIZE")
            }
        }
        gameBoard = board
    }

    @JsName("forEach")
    fun forEachNullable(yield: (element: Chessman?, newLine: Boolean, row: Int, column: Int) -> Unit) {
        var newLine = false
        gameBoard.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, chessman ->
                yield(chessman, newLine, rowIndex, columnIndex)
                newLine = false
            }
            newLine = true
        }
    }

    override fun iterator(): Iterator<ChessmanWithPosition> {
        return iterator {
            gameBoard.forEachIndexed { r, row ->
                row.forEachIndexed { c, chessman ->
                    if (chessman != null) {
                        yield(
                            ChessmanWithPosition(
                                chessman,
                                r,
                                c
                            )
                        )
                    }
                }
            }
        }
    }

    @JsName("contains")
    fun contains(row: Int, column: Int): Boolean =
        row in 0 until ROW_SIZE && column in 0 until COLUMN_SIZE

    operator fun contains(pos: Position): Boolean = contains(pos.row, pos.column)

    @JsName("get")
    operator fun get(row: Int, column: Int): Chessman? {
        if (contains(row, column)) return gameBoard[row][column]
        return null
    }

    operator fun get(position: Position): Chessman? =
        get(position.row, position.column)

    internal operator fun set(row: Int, column: Int, chessman: Chessman?) {
        if (contains(row, column)) {
            gameBoard[row][column] = chessman
        }
    }

    internal operator fun set(pos: Position, chessman: Chessman?) =
        set(pos.row, pos.column, chessman)

    companion object {
        const val ROW_SIZE = 10
        const val COLUMN_SIZE = 9
    }
}
