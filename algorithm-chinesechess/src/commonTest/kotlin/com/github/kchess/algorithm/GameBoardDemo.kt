package com.github.kchess.algorithm

import com.github.kchess.algorithm.Chessman.*

/**
 * @author YvesCheung
 * 2020/9/17
 */
object GameBoardDemo {

    val DEMO1 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(黑车, null, null, 黑士, 黑帅, 黑士, 黑象, 黑马, 黑车),
            /*1*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*2*/arrayOf(null, 黑炮, null, null, 黑象, null, 红车, 黑炮, null),
            /*3*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*4*/arrayOf(null, null, null, null, null, null, null, null, null),

            /*5*/arrayOf(红车, null, null, null, null, null, null, null, null),
            /*6*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*7*/arrayOf(null, 红炮, null, null, 红马, null, null, null, null),
            /*8*/arrayOf(null, null, null, null, 红士, null, null, null, null),
            /*9*/arrayOf(null, null, 红象, null, null, 红将, 红象, 红马, 红炮)
        )
}
