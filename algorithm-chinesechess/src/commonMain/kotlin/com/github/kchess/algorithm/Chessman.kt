package com.github.kchess.algorithm

import com.github.kchess.algorithm.OwnerShip.Player1
import com.github.kchess.algorithm.OwnerShip.Player2

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("EnumEntryName", "NonAsciiCharacters")
enum class Chessman(val owner: OwnerShip) {
    红车(Player1),
    红马(Player1),
    红象(Player1),
    红士(Player1),
    红将(Player1),
    红炮(Player1),
    红卒(Player1),

    黑车(Player2),
    黑马(Player2),
    黑象(Player2),
    黑士(Player2),
    黑帅(Player2),
    黑炮(Player2),
    黑兵(Player2);

    fun nextMove(current: Position): Iterable<Position> {
        return listOf(Position(current.r + 1, current.c + 1))
    }
}
