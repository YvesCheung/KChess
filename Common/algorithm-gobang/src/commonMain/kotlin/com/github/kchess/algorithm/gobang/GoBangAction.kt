package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.Game
import com.github.kchess.algorithm.GameAction

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
class GoBangAction(val piece: Pieces, val row: Int, val column: Int) : GameAction<Pieces> {

    override fun run(context: Game<Pieces>) {
        context.gameBoard[row, column] = piece
    }

    override fun undo(context: Game<Pieces>) {
        context.gameBoard[row, column] = null
    }
}
