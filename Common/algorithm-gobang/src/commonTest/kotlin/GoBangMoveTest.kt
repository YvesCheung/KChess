package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.Position
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO10
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO8
import com.github.kchess.algorithm.gobang.GoBangDemo.DEMO9
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * @author YvesCheung
 * 2020/10/20
 */
class GoBangMoveTest {

    private val game = GoBang()

    @Test
    fun testNextMove() {
        game.reset(DEMO8)
        val move = GoBangMoveGenerator.nextMove(game).toList()
        assertEquals(
            listOf(
                Position(0, 3),
                Position(0, 8)
            ),
            move
        )
    }

    @Test
    fun testNextMove2() {
        game.reset(DEMO9)
        val move = GoBangMoveGenerator.nextMove(game).toList()
        assertEquals(
            listOf(
                Position(row = 2, column = 4), Position(row = 0, column = 1), Position(row = 0, column = 2),
                Position(row = 0, column = 5), Position(row = 0, column = 6), Position(row = 1, column = 0),
                Position(row = 1, column = 1), Position(row = 1, column = 2), Position(row = 1, column = 3),
                Position(row = 1, column = 4), Position(row = 1, column = 6), Position(row = 2, column = 2),
                Position(row = 2, column = 3), Position(row = 2, column = 4), Position(row = 2, column = 5),
                Position(row = 2, column = 7), Position(row = 2, column = 8), Position(row = 3, column = 2),
                Position(row = 3, column = 4), Position(row = 3, column = 6), Position(row = 3, column = 7)
            ),
            move
        )
    }

    @Test
    fun testNextMove3() {
        game.reset(DEMO10)
        val move = GoBangMoveGenerator.nextMove(game).toList()
        assertEquals(
            listOf(
                Position(row=1, column=4), Position(row=0, column=4),
                Position(row=0, column=5), Position(row=0, column=6),
                Position(row=1, column=6), Position(row=2, column=4),
                Position(row=2, column=5), Position(row=2, column=6)),
            move
        )
    }
}
