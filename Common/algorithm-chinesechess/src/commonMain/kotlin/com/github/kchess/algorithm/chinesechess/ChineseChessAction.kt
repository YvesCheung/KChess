package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GamePieceWithPosition

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate")
class ChineseChessAction(
    val chessman: Chessman,
    val row: Int, val column: Int,
    val newRow: Int, val newColumn: Int
) : GameAction<ChineseChess> {

    constructor(chessman: GamePieceWithPosition<Chessman>, newRow: Int, newColumn: Int) :
        this(chessman.chessman, chessman.row, chessman.column, newRow, newColumn)

    private var eat: Chessman? = null

    override fun run(context: ChineseChess) {
        context.gameBoard[row, column] = null
        eat = context.gameBoard[newRow, newColumn]
        context.gameBoard[newRow, newColumn] = chessman
    }

    override fun undo(context: ChineseChess) {
        context.gameBoard[newRow, newColumn] = eat
        context.gameBoard[row, column] = chessman
    }

    override fun toString(): String {
        return "Move $chessman from [$row,$column] to [$newRow,$newColumn]"
    }
}
