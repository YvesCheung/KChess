package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.GameActionSearch
import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/30
 */
class GoBangSearch : GameActionSearch<GoBang>() {

    override fun evaluate(context: GoBang, player: OwnerShip): Int {
        TODO("Not yet implemented")
    }

    override fun nextMove(context: GoBang, player: OwnerShip): Sequence<GameAction<GoBang>> {
        return sequence {
            context.gameBoard.forEachNullable { piece, _, row, column ->
                if (piece == null) {
                    yield(GoBangAction(Pieces.of(player), row, column))
                }
            }
        }
    }
}
