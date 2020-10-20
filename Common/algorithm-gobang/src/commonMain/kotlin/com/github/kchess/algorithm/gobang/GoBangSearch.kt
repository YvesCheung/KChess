package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBangSearch : GameActionSearch<Pieces, GoBang>() {

    override fun evaluate(context: GoBang, player: OwnerShip): Int {
        return GoBangEvaluator.evaluate(context, player)
    }

    override fun nextMove(context: GoBang, depth: Int, player: OwnerShip): Sequence<GameAction<Pieces>> {
        val piece = Pieces.of(player)
        return GoBangMoveGenerator.nextMove(context)
            .map { (row, column) -> GoBangAction(piece, row, column) }
    }
}
