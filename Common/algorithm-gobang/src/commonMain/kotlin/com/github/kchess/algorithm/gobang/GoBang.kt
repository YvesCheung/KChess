package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.Game

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBang : Game<Pieces>() {

    override val autoSearch = GoBangSearch()

    /**
     * 棋盘
     */
    override val gameBoard = GoBangGameBoard()

    companion object {

        const val PIECE_IN_ROW = 5
    }

    override fun checkGameOver(): Boolean {
        TODO("Not yet implemented")
    }
}
