package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChess {

    /**
     * 棋盘
     */
    val gameBroad = ChineseChessBoard()

    /**
     * 当前是否红子回合
     */
    var currentPlayer: OwnerShip = OwnerShip.Player1
}


data class Position(val r: Int, val c: Int) {

    fun offset(offset: Position): Position = Position(r + offset.r, c + offset.c)
}
