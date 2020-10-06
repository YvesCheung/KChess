package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.Game
import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GamePieceWithPosition

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate")
data class ChineseChessAction(
    val chessman: Chessman,
    val row: Int, val column: Int,
    val newRow: Int, val newColumn: Int
) : GameAction<Chessman> {

    constructor(chessman: GamePieceWithPosition<Chessman>, newRow: Int, newColumn: Int) :
        this(chessman.chessman, chessman.row, chessman.column, newRow, newColumn)

    private var eat: Chessman? = null

    override fun run(context: Game<Chessman>) {
        if (context.gameBoard[row, column] !== chessman) {
            throw IllegalArgumentException("Run error: gameBoard[$row,$column] should be $chessman!")
        }
        context.gameBoard[row, column] = null
        eat = context.gameBoard[newRow, newColumn]
        context.gameBoard[newRow, newColumn] = chessman
    }

    override fun undo(context: Game<Chessman>) {
        if (context.gameBoard[newRow, newColumn] !== chessman) {
            throw IllegalArgumentException("Undo error: gameBoard[$newRow,$newColumn] should be $chessman!")
        }
        context.gameBoard[newRow, newColumn] = eat
        context.gameBoard[row, column] = chessman
    }

    override fun toString(): String {
        return "Move $chessman from [$row,$column] to [$newRow,$newColumn]"
    }
}
