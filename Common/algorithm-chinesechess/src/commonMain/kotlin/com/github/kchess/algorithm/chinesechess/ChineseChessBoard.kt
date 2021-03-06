package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.GameBoard
import com.github.kchess.algorithm.TestOnly
import com.github.kchess.algorithm.chinesechess.Chessman.红兵
import com.github.kchess.algorithm.chinesechess.Chessman.红士
import com.github.kchess.algorithm.chinesechess.Chessman.红将
import com.github.kchess.algorithm.chinesechess.Chessman.红炮
import com.github.kchess.algorithm.chinesechess.Chessman.红象
import com.github.kchess.algorithm.chinesechess.Chessman.红车
import com.github.kchess.algorithm.chinesechess.Chessman.红马
import com.github.kchess.algorithm.chinesechess.Chessman.黑卒
import com.github.kchess.algorithm.chinesechess.Chessman.黑士
import com.github.kchess.algorithm.chinesechess.Chessman.黑帅
import com.github.kchess.algorithm.chinesechess.Chessman.黑炮
import com.github.kchess.algorithm.chinesechess.Chessman.黑象
import com.github.kchess.algorithm.chinesechess.Chessman.黑车
import com.github.kchess.algorithm.chinesechess.Chessman.黑马

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChessBoard : GameBoard<Chessman>() {

    init {
        reset()
    }

    /**
     * [ROW_SIZE] * [COLUMN_SIZE]
     */
    override fun reset() {
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

    @TestOnly
    override fun reset(board: Array<Array<Chessman?>>) {
        if (board.size != ROW_SIZE) {
            throw IllegalArgumentException("board.size must be $ROW_SIZE")
        }
        board.forEachIndexed { index, row ->
            if (row.size != COLUMN_SIZE) {
                throw IllegalArgumentException("board[$index].size must be $COLUMN_SIZE")
            }
        }
        super.reset(board)
    }

    override fun contains(row: Int, column: Int): Boolean {
        return row in 0 until ROW_SIZE && column in 0 until COLUMN_SIZE
    }

    override fun toString(): String {

        fun chessman(c: Chessman) = "-${c.name}-"

        fun noChessman() = "--+--"

        val s = StringBuilder()
        forEach { (chessman, row, column) ->
            if (row != 0 && column == 0) {
                s.append('\n')
                s.append('\n')
            }
            if (chessman != null) s.append(chessman(chessman)) else s.append(noChessman())
        }
        s.append('\n')
        return s.toString()
    }

    companion object {
        const val ROW_SIZE = 10
        const val COLUMN_SIZE = 9
    }
}
