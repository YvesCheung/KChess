package com.github.kchess.algorithm

import com.github.kchess.algorithm.ChineseChessEvaluator.Companion.DEAD_VALUE
import com.github.kchess.algorithm.GameBoardDemo.DEMO4
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearchTest {

    @ExperimentalTime
    @Test
    fun testAlphaBeta() {
        val game = ChineseChess()
        val algorithm = ChineseChessSearch()

        println(measureTimedValue { algorithm.alphaBetaSearch(4, game) })
    }

    @Test
    fun checkDead() {
        val game = ChineseChess()
        game.reset(DEMO4)
        val algorithm = ChineseChessSearch()

        val deadValue = DEAD_VALUE
        ChineseChessEvaluator.values().forEach { evaluator ->
            if (evaluator == ChineseChessEvaluator.jiang) {
                evaluator.valueMap.all { row ->
                    row.all { value -> abs(value) < deadValue }
                }
            } else {
                evaluator.valueMap.any { row ->
                    row.any { value -> abs(value) > deadValue }
                }
            }
        }

        val player2 = abs(
            algorithm.alphaBetaSearch(2, game, OwnerShip.Player2).evaluateValue)
        assertTrue(player2 > deadValue)
        val player1 = abs(
            algorithm.alphaBetaSearch(2, game, OwnerShip.Player2).evaluateValue)
        assertTrue(player1 > deadValue)
    }
}
