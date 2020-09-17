package com.github.kchess.algorithm

import com.github.kchess.algorithm.GameBoardDemo.DEMO1
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

/**
 * @author YvesCheung
 * 2020/9/17
 */
class ChessmanRuleTest {

    private val rule = ChessmanRule.createFactory()

    private val game = ChineseChess()

    @BeforeTest
    fun resetGameBoard() {
        game.gameBroad.reset(DEMO1)
    }

    @Test
    fun testChe() {
        testChessman(
            0, 0, Chessman.黑车,
            listOf(
                Position(r = 1, c = 0),
                Position(r = 2, c = 0),
                Position(r = 3, c = 0),
                Position(r = 4, c = 0),
                Position(r = 5, c = 0),
                Position(r = 0, c = 1),
                Position(r = 0, c = 2)
            )
        )

        testChessman(
            0, 8, Chessman.黑车,
            listOf(
                Position(r = 1, c = 8),
                Position(r = 2, c = 8),
                Position(r = 3, c = 8),
                Position(r = 4, c = 8),
                Position(r = 5, c = 8),
                Position(r = 6, c = 8),
                Position(r = 7, c = 8),
                Position(r = 8, c = 8),
                Position(r = 9, c = 8)
            )
        )

        testChessman(
            5, 0, Chessman.红车,
            listOf(
                Position(r = 4, c = 0),
                Position(r = 3, c = 0),
                Position(r = 2, c = 0),
                Position(r = 1, c = 0),
                Position(r = 0, c = 0),
                Position(r = 6, c = 0),
                Position(r = 7, c = 0),
                Position(r = 8, c = 0),
                Position(r = 9, c = 0),
                Position(r = 5, c = 1),
                Position(r = 5, c = 2),
                Position(r = 5, c = 3),
                Position(r = 5, c = 4),
                Position(r = 5, c = 5),
                Position(r = 5, c = 6),
                Position(r = 5, c = 7),
                Position(r = 5, c = 8)
            )
        )

        testChessman(
            2, 6, Chessman.红车,
            listOf(
                Position(r = 1, c = 6),
                Position(r = 0, c = 6),
                Position(r = 3, c = 6),
                Position(r = 4, c = 6),
                Position(r = 5, c = 6),
                Position(r = 6, c = 6),
                Position(r = 7, c = 6),
                Position(r = 8, c = 6),
                Position(r = 2, c = 5),
                Position(r = 2, c = 4),
                Position(r = 2, c = 7)
            )
        )
    }

    @Test
    fun testMa() {
        testChessman(
            0, 7, Chessman.黑马,
            listOf(
                Position(r = 2, c = 6),
                Position(r = 2, c = 8)
            )
        )

        testChessman(
            7, 4, Chessman.红马,
            listOf(
                Position(r = 5, c = 3),
                Position(r = 5, c = 5),
                Position(r = 6, c = 2),
                Position(r = 8, c = 2),
                Position(r = 6, c = 6),
                Position(r = 8, c = 6)
            )
        )
    }

    @Test
    fun testXiang() {
        testChessman(
            2, 4, Chessman.黑象,
            listOf(
                Position(r = 0, c = 2),
                Position(r = 4, c = 2),
                Position(r = 4, c = 6)
            )
        )

        testChessman(
            9, 2, Chessman.红象,
            listOf()
        )
    }

    @Test
    fun testShi() {
        testChessman(
            8, 4, Chessman.红士,
            listOf(
                Position(r = 9, c = 3),
                Position(r = 7, c = 3),
                Position(r = 7, c = 5)
            )
        )

        testChessman(
            0, 3, Chessman.黑士,
            listOf(
                Position(r = 1, c = 4)
            )
        )
    }

    @Test
    fun testJiang() {
        testChessman(
            0, 4, Chessman.黑帅,
            listOf(
                Position(r = 1, c = 4)
            )
        )

        testChessman(
            9, 5, Chessman.红将,
            listOf(
                Position(r = 8, c = 5),
                Position(r = 9, c = 4)
            )
        )
    }

    private fun testChessman(
        row: Int,
        column: Int,
        expectChessman: Chessman,
        expectMovement: List<Position>
    ) {
        val chessman = game.gameBroad[row, column]!!
        assertSame(expectChessman, chessman)
        assertEquals(
            expectMovement,
            rule(chessman).nextMove(row, column, game).toList()
        )
    }
}
