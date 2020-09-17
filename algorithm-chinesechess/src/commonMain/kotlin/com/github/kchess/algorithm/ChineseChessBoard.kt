package com.github.kchess.algorithm

import com.github.kchess.algorithm.Chessman.*

/**
 * @author YvesCheung
 * 2020/9/16
 */
object ChineseChessBoard {

    /**
     * [ROW_SIZE] * [COLUMN_SIZE]
     */
    fun reset(): Array<Array<Chessman?>> {
        @Suppress("RemoveExplicitTypeArguments")
        return arrayOf<Array<Chessman?>>(
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


    const val ROW_SIZE = 10
    const val COLUMN_SIZE = 9
}
