package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
data class GameSearchResult<Game>(
    val action: GameAction<Game>?,
    val evaluateValue: Int
)
