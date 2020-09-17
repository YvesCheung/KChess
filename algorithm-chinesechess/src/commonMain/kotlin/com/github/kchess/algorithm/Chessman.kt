package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("EnumEntryName", "NonAsciiCharacters")
enum class Chessman(val redTurn: Boolean) {
    红车(true),
    红马(true),
    红象(true),
    红士(true),
    红将(true),
    红炮(true),
    红卒(true),

    黑车(false),
    黑马(false),
    黑象(false),
    黑士(false),
    黑帅(false),
    黑炮(false),
    黑兵(false);

    fun nextMove(current: Position): Iterable<Position> {
        return listOf(Position(current.r + 1, current.c + 1))
    }
}
