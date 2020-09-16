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
            arrayOf(车, Ma, Xiang, Shi, Jiang, Shi, Xiang, Ma, 车),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(null, Pao, null, null, null, null, null, Pao, null),
            arrayOf(Zu, null, Zu, null, Zu, null, Zu, null, Zu),
            arrayOf(null, null, null, null, null, null, null, null, null),

            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(Bin, null, Bin, null, Bin, null, Bin, null, Bin),
            arrayOf(null, Pao2, null, null, null, null, null, Pao2, null),
            arrayOf(null, null, null, null, null, null, null, null, null),
            arrayOf(Ju, Ma2, Xiang2, Shi2, 帅, Shi2, Xiang2, Ma2, Ju)
        )
    }


    const val ROW_SIZE = 10
    const val COLUMN_SIZE = 9
}
