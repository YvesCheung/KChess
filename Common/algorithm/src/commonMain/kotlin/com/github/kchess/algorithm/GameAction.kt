package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
interface GameAction<Game> {

    fun run(context: Game)

    fun undo(context: Game)
}
