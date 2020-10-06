package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
interface GameAction<Piece : Any> {

    fun run(context: Game<Piece>)

    fun undo(context: Game<Piece>)
}
