package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.Game

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBang : Game() {

    /**
     * 棋盘
     */
    val gameBoard = GoBangGameBoard()

    companion object {

        const val PIECE_IN_ROW = 5
    }
}
