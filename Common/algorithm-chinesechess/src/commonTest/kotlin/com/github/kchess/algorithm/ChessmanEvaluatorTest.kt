package com.github.kchess.algorithm

import com.github.kchess.algorithm.chinesechess.Chessman
import com.github.kchess.algorithm.chinesechess.ChineseChess
import com.github.kchess.algorithm.chinesechess.ChineseChessBoard.Companion.COLUMN_SIZE
import com.github.kchess.algorithm.chinesechess.ChineseChessBoard.Companion.ROW_SIZE
import com.github.kchess.algorithm.chinesechess.ChineseChessEvaluator
import kotlin.test.*

/**
 * @author YvesCheung
 * 2020/9/18
 */
class ChessmanEvaluatorTest {

    private val game = ChineseChess()

    @BeforeTest
    fun resetGameBoard() {
        game.reset(GameBoardDemo.DEMO2)
    }

    @Test
    fun testTwoPlayerEvaluateTheSame() {

        fun testTwoPlayerEvaluateTheSame(r: Int, c: Int, expectChessman: Chessman, evaluator: ChineseChessEvaluator) {
            val chessman = game.gameBoard[r, c]!!
            assertSame(expectChessman, chessman)

            val player1Value = ChineseChessEvaluator.evaluate(chessman, r, c, OwnerShip.Player1)
            if (chessman.owner == OwnerShip.Player1) {
                assertTrue(player1Value > 0)
                assertEquals(evaluator.valueMap[r][c], player1Value)
            } else {
                assertTrue(player1Value < 0)
                assertEquals(-evaluator.valueMap[ROW_SIZE - 1 - r][COLUMN_SIZE - 1 - c], player1Value)
            }
            val player2Value = ChineseChessEvaluator.evaluate(chessman, r, c, OwnerShip.Player2)
            assertEquals(-player1Value, player2Value)
        }

        testTwoPlayerEvaluateTheSame(2, 3, Chessman.红车, ChineseChessEvaluator.Che)
        testTwoPlayerEvaluateTheSame(7, 4, Chessman.红车, ChineseChessEvaluator.Che)
        testTwoPlayerEvaluateTheSame(4, 1, Chessman.黑马, ChineseChessEvaluator.Ma)
        testTwoPlayerEvaluateTheSame(5, 7, Chessman.黑马, ChineseChessEvaluator.Ma)
    }
}
