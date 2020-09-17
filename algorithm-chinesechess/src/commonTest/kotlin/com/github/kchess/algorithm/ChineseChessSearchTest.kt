package com.github.kchess.algorithm

import kotlin.test.Test

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearchTest {

    @Test
    fun testAlphaBeta() {
        val game = ChineseChess()
        val algorithm = ChineseChessSearch()
        println(algorithm.alphaBetaSearch(4, context = game))
    }
}
