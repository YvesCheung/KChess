package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessAction(
    private val chessman: Chessman,
    private val row: Int, private val column: Int,
    private val newRow: Int, private val newColumn: Int
) : GameAction<ChineseChess> {

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
