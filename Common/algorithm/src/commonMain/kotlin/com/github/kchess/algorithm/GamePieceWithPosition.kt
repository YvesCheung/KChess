package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/27
 */
data class GamePieceWithPosition<GamePiece : Any?>(
    val chessman: GamePiece,
    val row: Int,
    val column: Int
)
