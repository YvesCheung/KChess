package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
data class GameSearchResult<Piece : Any>(
    val action: GameAction<Piece>?,
    val evaluateValue: Int,
    val depth: Int
)
