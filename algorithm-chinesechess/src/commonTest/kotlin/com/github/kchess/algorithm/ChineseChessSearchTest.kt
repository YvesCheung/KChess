package com.github.kchess.algorithm

import kotlin.test.Test
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearchTest {

    @OptIn(ExperimentalTime::class)
    @Test
    fun testAlphaBeta() {
        val game = ChineseChess()
        val algorithm = ChineseChessSearch()

        println(measureTimedValue { algorithm.alphaBetaSearch(4, game) })

        println(measureTimedValue { algorithm.alphaBetaSearch(5, game) })

        println(measureTimedValue { algorithm.alphaBetaSearch(6, game) })
    }
}
