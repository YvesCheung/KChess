package com.github.kchess.algorithm

import com.github.kchess.algorithm.Chessman.红兵
import com.github.kchess.algorithm.Chessman.红士
import com.github.kchess.algorithm.Chessman.红将
import com.github.kchess.algorithm.Chessman.红炮
import com.github.kchess.algorithm.Chessman.红象
import com.github.kchess.algorithm.Chessman.红车
import com.github.kchess.algorithm.Chessman.红马
import com.github.kchess.algorithm.Chessman.黑卒
import com.github.kchess.algorithm.Chessman.黑士
import com.github.kchess.algorithm.Chessman.黑帅
import com.github.kchess.algorithm.Chessman.黑炮
import com.github.kchess.algorithm.Chessman.黑象
import com.github.kchess.algorithm.Chessman.黑车
import com.github.kchess.algorithm.Chessman.黑马
import com.github.kchess.algorithm.ChineseChessBoard.Companion.COLUMN_SIZE
import com.github.kchess.algorithm.ChineseChessBoard.Companion.ROW_SIZE

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("unused")
enum class ChessmanRule(vararg chessman: Chessman) : Producible<Chessman> {
    Che(红车, 黑车) {
        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequence {
                suspend fun SequenceScope<Position>.yieldPosition(r: Int, c: Int): Boolean {
                    val target = game.gameBoard[r, c]
                    if (target == null || target.owner != owner) yield(Position(r, c))
                    return target != null
                }
                for (r in current.r - 1 downTo 0) {
                    if (yieldPosition(r, current.c)) break
                }
                for (r in current.r + 1 until ROW_SIZE) {
                    if (yieldPosition(r, current.c)) break
                }
                for (c in current.c - 1 downTo 0) {
                    if (yieldPosition(current.r, c)) break
                }
                for (c in current.c + 1 until COLUMN_SIZE) {
                    if (yieldPosition(current.r, c)) break
                }
            }
        }
    },
    Ma(红马, 黑马) {
        private val top = arrayOf(Position(-2, -1), Position(-2, 1))
        private val left = arrayOf(Position(-1, -2), Position(1, -2))
        private val right = arrayOf(Position(-1, 2), Position(1, 2))
        private val bottom = arrayOf(Position(2, -1), Position(2, 1))

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            var step = emptyArray<Position>()
            //考虑绊马脚的情况
            if (game.gameBoard[current.r - 1, current.c] == null) step += top
            if (game.gameBoard[current.r + 1, current.c] == null) step += bottom
            if (game.gameBoard[current.r, current.c - 1] == null) step += left
            if (game.gameBoard[current.r, current.c + 1] == null) step += right
            return sequenceFromStep(current, step)
        }
    },
    Shi(红士, 黑士) {
        private val step = arrayOf(
            Position(1, 1), Position(1, -1),
            Position(-1, -1), Position(-1, 1)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequenceFromStep(current, step)
                .filter { //不能离开九宫格
                    it.c in 3..5 && (it.r in 0..2 || it.r in 7..9)
                }
        }

    },
    Xiang(红象, 黑象) {
        private val leftTop = arrayOf(Position(-2, -2))
        private val rightTop = arrayOf(Position(-2, 2))
        private val leftBottom = arrayOf(Position(2, -2))
        private val rightBottom = arrayOf(Position(2, 2))

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            var step = emptyArray<Position>()
            if (game.gameBoard[current.r - 1, current.c - 1] == null) step += leftTop
            if (game.gameBoard[current.r - 1, current.c + 1] == null) step += rightTop
            if (game.gameBoard[current.r + 1, current.c - 1] == null) step += leftBottom
            if (game.gameBoard[current.r + 1, current.c + 1] == null) step += rightBottom
            return sequenceFromStep(current, step)
                .filter { //不能过河
                    (!!owner && it.r > 4) || (!owner && it.r <= 4)
                }
        }
    },
    Jiang(红将, 黑帅) {
        private val step = arrayOf(
            Position(1, 0), Position(0, 1),
            Position(-1, 0), Position(0, -1)
        )

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            //todo:长将的情况
            return sequenceFromStep(current, step)
                .filter { //不能离开九宫格
                    it.c in 3..5 && (it.r in 0..2 || it.r in 7..9)
                }
        }
    },
    Bin(红兵, 黑卒) {
        private val toLeftRight = arrayOf(Position(0, 1), Position(0, -1))
        private val toTop = arrayOf(Position(-1, 0))
        private val toBottom = arrayOf(Position(1, 0))
        private val toTopLeftRight = toTop + toLeftRight
        private val toBottomLeftRight = toBottom + toLeftRight

        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return if (!!owner) {
                if (current.r <= 4) //过河
                    sequenceFromStep(current, toTopLeftRight)
                else
                    sequenceFromStep(current, toTop)
            } else {
                if (current.r > 4)
                    sequenceFromStep(current, toBottomLeftRight)
                else
                    sequenceFromStep(current, toBottom)
            }
        }
    },
    Pao(红炮, 黑炮) {
        override fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position> {
            return sequence {
                var hasBlock = false
                suspend fun SequenceScope<Position>.yieldPosition(r: Int, c: Int): Boolean {
                    val target = game.gameBoard[r, c]
                    if (hasBlock && target != null) {
                        if (target.owner != owner) {
                            yield(Position(r, c))
                        }
                        return true
                    } else if (target != null) {
                        hasBlock = true
                    } else if (!hasBlock) {
                        yield(Position(r, c))
                    }
                    return false
                }

                hasBlock = false
                for (r in current.r - 1 downTo 0) {
                    if (yieldPosition(r, current.c)) break
                }
                hasBlock = false
                for (r in current.r + 1 until ROW_SIZE) {
                    if (yieldPosition(r, current.c)) break
                }
                hasBlock = false
                for (c in current.c - 1 downTo 0) {
                    if (yieldPosition(current.r, c)) break
                }
                hasBlock = false
                for (c in current.c + 1 until COLUMN_SIZE) {
                    if (yieldPosition(current.r, c)) break
                }
            }
        }
    };

    override val productName: Array<out Chessman> = chessman

    protected abstract fun nextMove(current: Position, game: ChineseChess, owner: OwnerShip): Sequence<Position>

    companion object {

        private val factory = values().toFactory()

        fun nextMove(chessman: Chessman, currentRow: Int, currentColumn: Int, game: ChineseChess): Sequence<Position> {
            val rule = factory.create(chessman)
            return rule.nextMove(Position(currentRow, currentColumn), game, chessman.owner)
                .filter { (newRow, newColumn) ->
                    game.gameBoard.contains(newRow, newColumn) &&
                        (currentRow != newRow || currentColumn != newColumn) &&
                        game.gameBoard[newRow, newColumn]?.owner != chessman.owner
                }
        }

        /**
         * 根据[step]对[current]进行偏移，生成移动序列
         */
        private fun sequenceFromStep(current: Position, step: Array<Position>): Sequence<Position> =
            sequence {
                step.forEach { stepOffset ->
                    yield(current.offset(stepOffset))
                }
            }
    }
}
