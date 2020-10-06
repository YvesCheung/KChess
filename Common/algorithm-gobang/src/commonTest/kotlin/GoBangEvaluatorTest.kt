package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO1
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO2
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO3
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * @author YvesCheung
 * 2020/10/6
 */
@Suppress("ReplaceCallWithBinaryOperator")
class GoBangEvaluatorTest {

    private val game = GoBang()

    @Test
    fun testEvaluate1Row() {
        game.reset(DEMO1)
        val intArray = GoBangEvaluator.transform(game.gameBoard)
        assertEquals("0, 0, 0, 1, 2, 3, 4, 5, 6, 0", intArray.toString())

        game.reset(DEMO2)
        val intArray2 = GoBangEvaluator.transform(game.gameBoard)
        assertEquals("1, 0, 0, 1, 2, 3, 0, 1, 2", intArray2.toString())
    }

    @Test
    fun testEvaluate4Row() {
        game.reset(DEMO3)
        val intArray = GoBangEvaluator.transform(game.gameBoard)
        assertEquals("""
            1, 0, 0, 1, 1, 1, 0, 1, 1
            0, 0, 0, 0, 2, 2, 0, 2, 2
            1, 0, 0, 0, 2, 0, 0, 0, 0
            2, 0, 0, 3, 0, 2, 0, 0, 0
        """.trimIndent(), intArray.toString())
    }

    @Test
    fun testBlackEqualWhite() {
        fun assert() {
            val white = GoBangEvaluator.evaluate(game, OwnerShip.Player1)
            val black = GoBangEvaluator.evaluate(game, OwnerShip.Player2)
            println("$white, $black")
            assertEquals(white, -black)
        }

        game.reset(DEMO1)
        assert()

        game.reset(DEMO2)
        assert()

        game.reset(DEMO3)
        assert()
    }
}
