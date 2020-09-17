package com.github.kchess.algorithm

import com.github.kchess.algorithm.Chessman.*

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
    fun reset() {
        @Suppress("RemoveExplicitTypeArguments")
        gameBoard = arrayOf<Array<Chessman?>>(
            arrayOf(黑车, 黑马, 黑象, 黑士, 黑帅, 黑士, 黑象, 黑马, 黑车),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(null, 黑炮, null, null, null, null, null, 黑炮, null),
            arrayOf(黑兵, null, 黑兵, null, 黑兵, null, 黑兵, null, 黑兵),
            arrayOf(null, null, null, null, null, null, null, null, null),

            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(红卒, null, 红卒, null, 红卒, null, 红卒, null, 红卒),
            arrayOf(null, 红炮, null, null, null, null, null, 红炮, null),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(红车, 红马, 红象, 红士, 红将, 红士, 红象, 红马, 红车)
        )
    }

    fun reset(board: Array<Array<Chessman?>>) {
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

    fun allRows(): Iterator<Iterator<Chessman?>> {
        return iterator {
            gameBoard.forEach { row ->
                yield(row.iterator())
            }
        }
    }

    override fun iterator(): Iterator<ChessmanWithPosition> {
        return iterator {
            gameBoard.forEachIndexed { r, row ->
                row.forEachIndexed { c, chessman ->
                    if (chessman != null) {
                        yield(ChessmanWithPosition(chessman, r, c))
                    }
                }
            }
        }
    }

    fun contains(row: Int, column: Int): Boolean =
        row in 0 until ROW_SIZE && column in 0 until COLUMN_SIZE

    operator fun contains(pos: Position): Boolean = contains(pos.r, pos.c)

    operator fun get(row: Int, column: Int): Chessman? {
        if (contains(row, column)) return gameBoard[row][column]
        return null
    }

    operator fun set(row: Int, column: Int, chessman: Chessman?) {
        if (contains(row, column)) {
            gameBoard[row][column] = chessman
        }
    }

    companion object {
        const val ROW_SIZE = 10
        const val COLUMN_SIZE = 9
    }
}

data class ChessmanWithPosition(val chessman: Chessman, val row: Int, val column: Int)
