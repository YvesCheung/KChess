package com.github.kchess.algorithm

import com.github.kchess.algorithm.chinesechess.Chessman
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
 * 2020/9/17
 */
object GameBoardDemo {

    val DEMO1 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(黑车, null, null, 黑士, 黑帅, 黑士, 黑象, 黑马, 黑车),
            /*1*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*2*/arrayOf(null, 黑炮, null, null, 黑象, null, 红车, 黑炮, null),
            /*3*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*4*/arrayOf(null, null, null, null, 黑卒, null, null, 红兵, null),

            /*5*/arrayOf(红车, null, null, null, null, null, null, null, null),
            /*6*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*7*/arrayOf(null, 红炮, null, null, 红马, null, null, null, null),
            /*8*/arrayOf(null, 黑马, null, null, 红士, null, null, null, null),
            /*9*/arrayOf(null, null, 红象, null, null, 红将, 红象, 红马, 红炮)
        )

    val DEMO2 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*1*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*2*/arrayOf(null, null, null, 红车, null, null, null, null, null),
            /*3*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*4*/arrayOf(null, 黑马, null, null, null, null, null, null, null),

            /*5*/arrayOf(null, null, null, null, null, null, null, 黑马, null),
            /*6*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*7*/arrayOf(null, null, null, null, 红车, null, null, null, null),
            /*8*/arrayOf(null, null, null, null, null, null, null, null, null),
            /*9*/arrayOf(null, null, null, null, null, null, null, null, null)
        )

    val DEMO3 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/黑士, /*4*/黑帅, /*5*/黑士, /*6*/黑象, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑象, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*3*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红炮, /*5*/黑车, /*6*/null, /*7*/null, /*8*/黑卒),
            /*4*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/黑卒, /*7*/null, /*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/黑卒, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/黑车, /*8*/红兵),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红象, /*5*/null, /*6*/红马, /*7*/黑炮, /*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/红车, /*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/红象, /*3*/红士, /*4*/红将, /*5*/红士, /*6*/null, /*7*/null, /*8*/null)
        )

    val DEMO4 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑帅, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红马, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*3*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红炮, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*7*/arrayOf(/*0*/黑车, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/黑车, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红将, /*5*/null, /*6*/null, /*7*/null, /*8*/null)
        )

    val DEMO5 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红炮, /*4*/黑帅, /*5*/红炮, /*6*/null, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/黑帅, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/黑帅, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*3*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红炮, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红将, /*4*/null, /*5*/红将, /*6*/null, /*7*/null, /*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红将, /*5*/null, /*6*/null, /*7*/null, /*8*/null)
        )

    val DEMO6 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/红炮, /*1*/null, /*2*/红车, /*3*/null, /*4*/黑帅, /*5*/黑士, /*6*/黑象, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑士, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/黑马, /*1*/null, /*2*/null, /*3*/null, /*4*/黑象, /*5*/null, /*6*/null, /*7*/黑炮,/*8*/null),
            /*3*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/红兵, /*7*/null,/*8*/null),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红车, /*4*/null, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/红兵, /*1*/null, /*2*/null, /*3*/null, /*4*/黑车, /*5*/黑车, /*6*/null, /*7*/null,/*8*/红兵),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红象, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/黑炮, /*2*/null, /*3*/红炮, /*4*/红马, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红士, /*4*/红将, /*5*/红士, /*6*/红象, /*7*/null,/*8*/null)
        )

    val DEMO7 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/红炮, /*1*/红马, /*2*/null, /*3*/null, /*4*/黑帅, /*5*/黑士, /*6*/黑象, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑士, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/黑炮, /*4*/黑象, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*3*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/黑卒, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/黑炮, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/红兵, /*1*/null, /*2*/null, /*3*/null, /*4*/红兵, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null,/*8*/黑马),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红士, /*5*/红炮, /*6*/null, /*7*/null,/*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红将, /*5*/红士, /*6*/null, /*7*/null,/*8*/null)
        )

    val DEMO8 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/红车, /*2*/黑象, /*3*/null, /*4*/黑帅, /*5*/黑士, /*6*/null, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红马, /*4*/黑士, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/红车, /*3*/null, /*4*/黑象, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*3*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红炮, /*5*/黑马, /*6*/null, /*7*/null,/*8*/null),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/红兵, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/红兵, /*1*/null, /*2*/null, /*3*/null, /*4*/红兵, /*5*/null, /*6*/黑马, /*7*/null,/*8*/红兵),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/红炮, /*4*/null, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红士, /*5*/null, /*6*/null, /*7*/null,/*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/红象, /*3*/红士, /*4*/红将, /*5*/null, /*6*/null, /*7*/黑炮,/*8*/null)
        )

    val DEMO9 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/null, /*2*/红车, /*3*/null, /*4*/黑帅, /*5*/黑士, /*6*/null, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑士, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/黑炮, /*7*/null, /*8*/null),
            /*3*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/黑卒, /*5*/null, /*6*/红马, /*7*/null, /*8*/黑卒),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/红兵, /*7*/null, /*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红兵, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/红兵, /*1*/null, /*2*/null, /*3*/null, /*4*/黑车, /*5*/null, /*6*/null, /*7*/null, /*8*/红兵),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红象, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/红象, /*3*/红士, /*4*/红将, /*5*/红士, /*6*/null, /*7*/null, /*8*/null)
        )

    val DEMO10 =
        arrayOf<Array<Chessman?>>(
            /*0*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑帅, /*5*/黑士, /*6*/红车, /*7*/null, /*8*/null),
            /*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑士, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/黑炮, /*6*/null, /*7*/null, /*8*/黑马),
            /*3*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/黑卒),
            /*4*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/黑车, /*7*/null, /*8*/null),
            /*5*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红马, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*6*/arrayOf(/*0*/红兵, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/红兵),
            /*7*/arrayOf(/*0*/null, /*1*/null, /*2*/红马, /*3*/黑马, /*4*/红象, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
            /*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红士, /*5*/红将, /*6*/null, /*7*/null, /*8*/null),
            /*9*/arrayOf(/*0*/null, /*1*/null, /*2*/红象, /*3*/红士, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null)
        )
}
