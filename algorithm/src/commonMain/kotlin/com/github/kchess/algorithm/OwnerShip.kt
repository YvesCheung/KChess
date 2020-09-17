package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/17
 */
enum class OwnerShip {
    Player1, Player2;

    operator fun not(): Boolean = this === Player1

    operator fun unaryMinus(): OwnerShip = if (this === Player1) Player2 else Player1
}
