package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.OwnerShip

/**
 * @author YvesCheung
 * 2020/9/30
 */
enum class Pieces {
    WHITE,
    BLACK;

    companion object {
        fun of(player: OwnerShip): Pieces =
            if (player.toBoolean()) WHITE else BLACK
    }
}

infix fun Pieces?.belongsTo(player: OwnerShip): Boolean {
    val isWhite = player.toBoolean()
    return (isWhite && this === Pieces.WHITE) || (!isWhite && this === Pieces.BLACK)
}
