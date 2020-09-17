package com.github.kchess.algorithm

import com.github.kchess.algorithm.Chessman.*
import com.github.kchess.algorithm.ChineseChessBoard.COLUMN_SIZE
import com.github.kchess.algorithm.ChineseChessBoard.ROW_SIZE

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("unused")
enum class ChessmanRule(vararg val chessman: Chessman) {
    Che(红车, 黑车) {
        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequence {
                for (r in 0 until ROW_SIZE) yield(Position(r, current.c))
                for (c in 0 until COLUMN_SIZE) yield(Position(current.r, c))
            }
        }
    },
    Ma(红马, 黑马) {
        private val step = arrayOf(
            Position(1, 2), Position(2, 1),
            Position(-1, -2), Position(-2, -1),
            Position(1, -2), Position(2, -1),
            Position(-1, 2), Position(-2, 1)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> =
            sequenceFromStep(current, step)
    },
    Shi(红士, 黑士) {
        private val step = arrayOf(
            Position(1, 1), Position(1, -1),
            Position(-1, -1), Position(-1, 1)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequenceFromStep(current, step)
                .filter { //不能离开九宫格
                    it.r in 3..5 && (it.c in 0..2 || it.c in 7..9)
                }
        }

    },
    Xiang(红象, 黑象) {
        private val step = arrayOf(
            Position(2, 2), Position(2, -2),
            Position(-2, -2), Position(-2, 2)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequenceFromStep(current, step)
                .filter { //不能过河
                    (!!owner && it.c > 4) || (!owner && it.c <= 4)
                }
        }
    },
    Jiang(红将, 黑帅) {
        private val step = arrayOf(
            Position(1, 0), Position(0, 1),
            Position(-1, 0), Position(0, -1)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequenceFromStep(current, step)
                .filter { //不能离开九宫格
                    it.r in 3..5 && (it.c in 0..2 || it.c in 7..9)
                }
        }
    },
    Bin(红卒, 黑兵) {
        private val toLeftRight = arrayOf(Position(0, 1), Position(0, -1))
        private val toTop = arrayOf(Position(1, 0))
        private val toBottom = arrayOf(Position(-1, 0))
        private val toTopLeftRight = toTop + toLeftRight
        private val toBottomLeftRight = toBottom + toLeftRight

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return if (!!owner) {
                if (current.c <= 4) //过河
                    sequenceFromStep(current, toTopLeftRight)
                else
                    sequenceFromStep(current, toTop)
            } else {
                if (current.c > 4)
                    sequenceFromStep(current, toBottomLeftRight)
                else
                    sequenceFromStep(current, toBottom)
            }
        }
    },
    Pao(红炮, 黑炮) {
        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            var hasBlock = false
            for (r in current.r - 1 downTo 0) {
                val target = game.gameBroad[r][current.c]
                if(hasBlock && target?.owner != owner){

                }
                if (game.gameBroad[r][current.c] != null) {
                    hasBlock = true
                }
            }
            return Che.nextMove(current, game, owner)
        }
    };

    abstract fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position>

    companion object {

        /**
         * 根据[step]对[current]进行偏移，生成移动序列
         */
        private fun sequenceFromStep(current: Position, step: Array<Position>): Sequence<Position> =
            sequence {
                step.forEach { stepOffset ->
                    yield(current.offset(stepOffset))
                }
            }

        fun createFactory(): (Chessman) -> ChessmanRule {
            val map = mutableMapOf<Chessman, ChessmanRule>()
            values().forEach { rule ->
                rule.chessman.forEach { chessman ->
                    map[chessman] = rule
                }
            }
            return { map[it]!! }
        }
    }
}
