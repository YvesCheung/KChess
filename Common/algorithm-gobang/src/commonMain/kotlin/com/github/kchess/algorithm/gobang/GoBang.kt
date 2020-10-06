package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.Game
import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBang : Game<Pieces>() {

    /**
     * 棋盘
     */
    override val gameBoard = GoBangGameBoard()

    override val autoSearch = GoBangSearch()

    override fun checkGameOver(): Boolean {
        val matrix = GoBangEvaluator.transform(gameBoard)
        return matrix.any { (vector) -> (vector?.max ?: 0) >= PIECE_IN_ROW }
    }

    override fun autoMoveAction(player: OwnerShip): GameAction<Pieces>? {
        return autoSearch.alphaBetaSearch(5, this, player).action
    }

    companion object {
        const val PIECE_IN_ROW = 5
    }
}
