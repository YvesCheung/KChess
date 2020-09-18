package com.github.kchess.algorithm

import com.github.kchess.algorithm.OwnerShip.Player1
import com.github.kchess.algorithm.OwnerShip.Player2

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("EnumEntryName", "NonAsciiCharacters")
enum class Chessman(val owner: OwnerShip, val desc: String) {
    红车(Player1, "红车"),
    红马(Player1, "红马"),
    红象(Player1, "红象"),
    红士(Player1, "红士"),
    红将(Player1, "红将"),
    红炮(Player1, "红炮"),
    红兵(Player1, "红兵"),

    黑车(Player2, "黑车"),
    黑马(Player2, "黑马"),
    黑象(Player2, "黑象"),
    黑士(Player2, "黑士"),
    黑帅(Player2, "黑帅"),
    黑炮(Player2, "黑炮"),
    黑卒(Player2, "黑卒");

    override fun toString(): String = desc
}
