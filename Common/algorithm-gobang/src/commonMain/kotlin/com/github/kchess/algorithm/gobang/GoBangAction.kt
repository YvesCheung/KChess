package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameAction

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
class GoBangAction(val piece: Pieces, val row: Int, val column: Int) : GameAction<GoBang> {

    override fun run(context: GoBang) {
        context.gameBoard[row, column] = piece
    }

    override fun undo(context: GoBang) {
        context.gameBoard[row, column] = null
    }
}
