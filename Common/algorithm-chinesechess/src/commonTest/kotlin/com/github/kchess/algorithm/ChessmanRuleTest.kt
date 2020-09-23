package com.github.kchess.algorithm

import com.github.kchess.algorithm.GameBoardDemo.DEMO1
import com.github.kchess.algorithm.GameBoardDemo.DEMO3
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

/**
 * @author YvesCheung
 * 2020/9/17
 */
class ChessmanRuleTest {

    private val game = ChineseChess()

    @BeforeTest
    fun resetGameBoard() {
        game.reset(DEMO1)
    }

    @Test
    fun testChe() {
        testChessman(
            0, 0, Chessman.黑车,
            listOf(
                Position(row = 1, column = 0),
                Position(row = 2, column = 0),
                Position(row = 3, column = 0),
                Position(row = 4, column = 0),
                Position(row = 5, column = 0),
                Position(row = 0, column = 1),
                Position(row = 0, column = 2)
            )
        )

        testChessman(
            0, 8, Chessman.黑车,
            listOf(
                Position(row = 1, column = 8),
                Position(row = 2, column = 8),
                Position(row = 3, column = 8),
                Position(row = 4, column = 8),
                Position(row = 5, column = 8),
                Position(row = 6, column = 8),
                Position(row = 7, column = 8),
                Position(row = 8, column = 8),
                Position(row = 9, column = 8)
            )
        )

        testChessman(
            5, 0, Chessman.红车,
            listOf(
                Position(row = 4, column = 0),
                Position(row = 3, column = 0),
                Position(row = 2, column = 0),
                Position(row = 1, column = 0),
                Position(row = 0, column = 0),
                Position(row = 6, column = 0),
                Position(row = 7, column = 0),
                Position(row = 8, column = 0),
                Position(row = 9, column = 0),
                Position(row = 5, column = 1),
                Position(row = 5, column = 2),
                Position(row = 5, column = 3),
                Position(row = 5, column = 4),
                Position(row = 5, column = 5),
                Position(row = 5, column = 6),
                Position(row = 5, column = 7),
                Position(row = 5, column = 8)
            )
        )

        testChessman(
            2, 6, Chessman.红车,
            listOf(
                Position(row = 1, column = 6),
                Position(row = 0, column = 6),
                Position(row = 3, column = 6),
                Position(row = 4, column = 6),
                Position(row = 5, column = 6),
                Position(row = 6, column = 6),
                Position(row = 7, column = 6),
                Position(row = 8, column = 6),
                Position(row = 2, column = 5),
                Position(row = 2, column = 4),
                Position(row = 2, column = 7)
            )
        )
    }

    @Test
    fun testChe2() {
        game.reset(DEMO3)

        testChessman(3, 5, Chessman.黑车,
            listOf(
                Position(row = 2, column = 5),
                Position(row = 1, column = 5),
                Position(row = 4, column = 5),
                Position(row = 5, column = 5),
                Position(row = 6, column = 5),
                Position(row = 7, column = 5),
                Position(row = 8, column = 5),
                Position(row = 9, column = 5),
                Position(row = 3, column = 4),
                Position(row = 3, column = 6),
                Position(row = 3, column = 7)
            ))
    }

    @Test
    fun testMa() {
        testChessman(
            0, 7, Chessman.黑马,
            listOf(
                Position(row = 2, column = 6),
                Position(row = 2, column = 8)
            )
        )

        testChessman(
            7, 4, Chessman.红马,
            listOf(
                Position(row = 5, column = 3),
                Position(row = 5, column = 5),
                Position(row = 6, column = 2),
                Position(row = 8, column = 2),
                Position(row = 6, column = 6),
                Position(row = 8, column = 6)
            )
        )
    }

    @Test
    fun testPao() {
        testChessman(2, 1, Chessman.黑炮,
            listOf(
                Position(row = 1, column = 1),
                Position(row = 0, column = 1),
                Position(row = 3, column = 1),
                Position(row = 4, column = 1),
                Position(row = 5, column = 1),
                Position(row = 6, column = 1),
                Position(row = 2, column = 0),
                Position(row = 2, column = 2),
                Position(row = 2, column = 3),
                Position(row = 2, column = 6)
            ))

        testChessman(2, 7, Chessman.黑炮,
            listOf(
                Position(row = 1, column = 7),
                Position(row = 3, column = 7),
                Position(row = 9, column = 7),
                Position(row = 2, column = 8)
            ))
    }

    @Test
    fun testXiang() {
        testChessman(
            2, 4, Chessman.黑象,
            listOf(
                Position(row = 0, column = 2),
                Position(row = 4, column = 2),
                Position(row = 4, column = 6)
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
                Position(row = 9, column = 3),
                Position(row = 7, column = 3),
                Position(row = 7, column = 5)
            )
        )

        testChessman(
            0, 3, Chessman.黑士,
            listOf(
                Position(row = 1, column = 4)
            )
        )
    }

    @Test
    fun testJiang() {
        testChessman(
            0, 4, Chessman.黑帅,
            listOf(
                Position(row = 1, column = 4)
            )
        )

        testChessman(
            9, 5, Chessman.红将,
            listOf(
                Position(row = 8, column = 5),
                Position(row = 9, column = 4)
            )
        )
    }

    @Test
    fun testBin() {
        testChessman(4, 4, Chessman.黑卒,
            listOf(Position(row = 5, column = 4))
        )

        testChessman(4, 7, Chessman.红兵,
            listOf(
                Position(row = 3, column = 7),
                Position(row = 4, column = 8),
                Position(row = 4, column = 6)
            ))
    }

    private fun testChessman(
        row: Int,
        column: Int,
        expectChessman: Chessman,
        expectMovement: List<Position>
    ) {
        val chessman = game.gameBoard[row, column]!!
        assertSame(expectChessman, chessman)
        assertEquals(
            expectMovement,
            ChessmanRule.nextMove(chessman, row, column, game).toList()
        )
    }
}
