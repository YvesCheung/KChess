package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChessAction(
    private val chessman: Chessman,
    private val x: Int, private val y: Int,
    private val newX: Int, private val newY: Int
) : GameAction<ChineseChess> {

    private var eat: Chessman? = null

    override fun run(context: ChineseChess) {
        context.gameBroad[x, y] = null
        eat = context.gameBroad[newX, newY]
        context.gameBroad[newX, newY] = chessman
    }

    override fun undo(context: ChineseChess) {
        context.gameBroad[newX, newY] = eat
        context.gameBroad[x, y] = chessman
    }

    override fun toString(): String {
        return "Move $chessman from [$x,$y] to [$newX,$newY]"
    }
}
