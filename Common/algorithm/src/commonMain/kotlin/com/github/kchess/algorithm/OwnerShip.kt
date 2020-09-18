package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/17
 */
@Suppress("MemberVisibilityCanBePrivate")
enum class OwnerShip {
    Player1, Player2;

    operator fun not(): Boolean = !toBoolean()

    operator fun unaryMinus(): OwnerShip = if (this === Player1) Player2 else Player1

    fun toBoolean(): Boolean = this === Player1
}
