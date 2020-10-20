package com.github.kchess.algorithm.gobang

/**
 * @author YvesCheung
 * 2020/10/6
 */
object GoBangDemo {

    val DEMO1 = Array(1) {
        arrayOf(null, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null)
    }

    val DEMO2 = Array(1) {
        arrayOf(Pieces.BLACK, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null, Pieces.BLACK, Pieces.BLACK)
    }

    val DEMO3 = arrayOf(
        arrayOf(Pieces.BLACK, null, null, Pieces.BLACK, Pieces.WHITE, Pieces.BLACK, null, Pieces.BLACK, Pieces.WHITE),
        arrayOf(null, null, null, null, Pieces.BLACK, Pieces.WHITE, null, Pieces.BLACK, Pieces.BLACK),
        arrayOf(Pieces.BLACK, null, null, null, Pieces.WHITE, null, null, null, null),
        arrayOf(Pieces.BLACK, null, null, Pieces.WHITE, null, Pieces.WHITE, null, null, null)
    )

    val DEMO4 = Array(1) {
        arrayOf(null, null, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null)
    }

    val DEMO5 = Array(1) {
        arrayOf(null, null, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null, null)
    }

    val DEMO6 = Array(1) {
        arrayOf(null, null, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null, null, null)
    }

    val DEMO7 = Array(1) {
        arrayOf(null, null, null, Pieces.WHITE, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, null, null, null)
    }

    val DEMO8 = Array(1) {
        arrayOf(null, null, null, null, Pieces.BLACK, Pieces.BLACK, Pieces.BLACK, Pieces.WHITE, null, null)
    }
}
