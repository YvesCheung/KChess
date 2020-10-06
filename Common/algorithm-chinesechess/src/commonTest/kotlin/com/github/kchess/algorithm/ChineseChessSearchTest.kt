package com.github.kchess.algorithm

import com.github.kchess.algorithm.GameBoardDemo.DEMO4
import com.github.kchess.algorithm.GameBoardDemo.DEMO6
import com.github.kchess.algorithm.GameBoardDemo.DEMO7
import com.github.kchess.algorithm.GameBoardDemo.DEMO8
import com.github.kchess.algorithm.GameBoardDemo.DEMO9
import com.github.kchess.algorithm.chinesechess.Chessman.黑士
import com.github.kchess.algorithm.chinesechess.ChineseChess
import com.github.kchess.algorithm.chinesechess.ChineseChessAction
import com.github.kchess.algorithm.chinesechess.ChineseChessEvaluator
import com.github.kchess.algorithm.chinesechess.ChineseChessEvaluator.Companion.DEAD_VALUE
import com.github.kchess.algorithm.chinesechess.ChineseChessSearch
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessSearchTest {

    private val game = ChineseChess()
    private val algorithm = ChineseChessSearch()

    @ExperimentalTime
    @Test
    fun testAlphaBeta() {
        game.reset()
        println(measureTimedValue { algorithm.alphaBetaSearch(4, game) })
    }

    @Test
    fun checkDead() {
        game.reset(DEMO4)

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

    @Test
    fun dontKillItself() {
        game.reset(DEMO6)

        val action =
            algorithm.alphaBetaSearch(5, game, OwnerShip.Player2)
        assertEquals(ChineseChessAction(黑士, 1, 4, 0, 3), action.action)
    }

    @Test
    fun dontKillItself2() {
        game.reset(DEMO7)

        val action =
            algorithm.alphaBetaSearch(4, game, OwnerShip.Player2)
        assertEquals(ChineseChessAction(黑士, 1, 4, 0, 3), action.action)
    }

    @Test
    fun dontKillItSelf3() {
        game.reset(DEMO8)

        val action =
            algorithm.alphaBetaSearch(5, game, OwnerShip.Player2)
        println(action)
    }
}
