package com.github.kchess.algorithm

import com.github.kchess.algorithm.ChineseChessBoard.Companion.COLUMN_SIZE
import com.github.kchess.algorithm.ChineseChessBoard.Companion.ROW_SIZE

/**
 * @author YvesCheung
 * 2020/9/16
 */
enum class ChessmanEvaluator(vararg chessman: Chessman) : Producible<Chessman> {
    Che(Chessman.红车, Chessman.黑车) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(206, 208, 207, 213, 214, 213, 207, 208, 206),
            intArrayOf(206, 212, 209, 216, 233, 216, 209, 212, 206),
            intArrayOf(206, 208, 207, 214, 216, 214, 207, 208, 206),
            intArrayOf(206, 213, 213, 216, 216, 216, 213, 213, 206),
            intArrayOf(208, 211, 211, 214, 215, 214, 211, 211, 208),

            intArrayOf(208, 212, 212, 214, 215, 214, 212, 212, 208),
            intArrayOf(204, 209, 204, 212, 214, 212, 204, 209, 204),
            intArrayOf(198, 208, 204, 212, 212, 212, 204, 208, 198),
            intArrayOf(200, 208, 206, 212, 200, 212, 206, 208, 200),
            intArrayOf(194, 206, 204, 212, 200, 212, 204, 206, 194)
        )
    },
    Ma(Chessman.红马, Chessman.黑马) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(90, 90, 90, 96, 90, 96, 90, 90, 90),
            intArrayOf(90, 96, 103, 97, 94, 97, 103, 96, 90),
            intArrayOf(92, 98, 99, 103, 99, 103, 99, 98, 92),
            intArrayOf(93, 108, 100, 107, 100, 107, 100, 108, 93),
            intArrayOf(90, 100, 99, 103, 104, 103, 99, 100, 90),

            intArrayOf(90, 98, 101, 102, 103, 102, 101, 98, 90),
            intArrayOf(92, 94, 98, 95, 98, 95, 98, 94, 92),
            intArrayOf(93, 92, 94, 95, 92, 95, 94, 92, 93),
            intArrayOf(85, 90, 92, 93, 78, 93, 92, 90, 85),
            intArrayOf(88, 85, 90, 88, 90, 88, 90, 85, 88)
        )
    },
    Xiang(Chessman.红象, Chessman.黑象) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),

            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(18, 0, 0, 0, 23, 0, 0, 0, 18),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0)
        )
    },
    Shi(Chessman.红士, Chessman.黑士) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),

            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 23, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0)
        )
    },
    jiang(Chessman.红将, Chessman.黑帅) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0),
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0),
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),

            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0),
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0),
            intArrayOf(0, 0, 0, 999999, 999999, 999999, 0, 0, 0)
        )
    },
    Pao(Chessman.红炮, Chessman.黑炮) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(100, 100, 96, 91, 90, 91, 96, 100, 100),
            intArrayOf(98, 98, 96, 92, 89, 92, 96, 98, 98),
            intArrayOf(97, 97, 96, 91, 92, 91, 96, 97, 97),
            intArrayOf(96, 99, 99, 98, 100, 98, 99, 99, 96),
            intArrayOf(96, 96, 96, 96, 100, 96, 96, 96, 96),

            intArrayOf(95, 96, 99, 96, 100, 96, 99, 96, 95),
            intArrayOf(96, 96, 96, 96, 96, 96, 96, 96, 96),
            intArrayOf(97, 96, 100, 99, 101, 99, 100, 96, 97),
            intArrayOf(96, 97, 98, 98, 98, 98, 98, 97, 96),
            intArrayOf(96, 96, 97, 99, 99, 99, 97, 96, 96)
        )
    },
    Zu(Chessman.红兵, Chessman.黑卒) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(9, 9, 9, 11, 13, 11, 9, 9, 9),
            intArrayOf(19, 24, 34, 42, 44, 42, 34, 24, 19),
            intArrayOf(19, 24, 32, 37, 37, 37, 32, 24, 19),
            intArrayOf(19, 23, 27, 29, 30, 29, 27, 23, 19),
            intArrayOf(14, 18, 20, 27, 29, 27, 20, 18, 14),

            intArrayOf(7, 0, 13, 0, 16, 0, 13, 0, 7),
            intArrayOf(7, 0, 7, 0, 15, 0, 7, 0, 7),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        )
    };

    override val productName: Array<out Chessman> = chessman

    abstract val valueMap: Array<IntArray>

    companion object {

        /**
         * 只有[ChessmanEvaluator.jiang]的价值大于这个值，
         * 其余所有棋子的价值都远低于这个值。可以用来判断是否将死。
         */
        const val DEAD_VALUE = 900000

        private val factory = values().toFactory()

        fun evaluate(chessman: Chessman, row: Int, column: Int, player: OwnerShip): Int {
            val evaluator = factory.create(chessman)
            val evaluate =
                if (!chessman.owner) {
                    evaluator.valueMap[ROW_SIZE - row - 1][COLUMN_SIZE - column - 1]
                } else {
                    evaluator.valueMap[row][column]
                }
            return if (chessman.owner != player) {
                -evaluate
            } else {
                evaluate
            }
        }
    }
}
