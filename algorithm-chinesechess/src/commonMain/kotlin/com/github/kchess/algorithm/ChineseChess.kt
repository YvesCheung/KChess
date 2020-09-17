package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChess {

    /**
     * 棋盘
     */
    val gameBroad: Array<Array<Chessman?>> = ChineseChessBoard.reset()

    /**
     * 当前是否红子回合
     */
    var redTurn: Boolean = true
}


data class Position(val r: Int, val c: Int) {

    fun offset(offset: Position): Position = Position(r + offset.r, c + offset.c)
}
