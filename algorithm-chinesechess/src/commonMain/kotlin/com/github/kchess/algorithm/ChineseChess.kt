package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/9/16
 */
class ChineseChess {

    /**
     * 棋盘
     */
    val gameBroad: Array<Array<Chessman?>> = ChineseChessBoard.reset()

    /**
     * 当前是否红子回合
     */
    var redTurn: Boolean = true
}

enum class Chessman(val redTurn: Boolean) {
    车(true), Ma(true), Xiang(true), Shi(true),
    Jiang(true), Pao(true), Zu(true),

    Ju(false), Ma2(false), Xiang2(false), Shi2(false),
    帅(false), Pao2(false), Bin(false);

    fun nextMove(current: Position): Iterable<Position> {
        return listOf(Position(current.x + 1, current.y + 1))
    }
}

enum class ChessmanEvaluator(vararg val belongTo: Chessman) {
    Che(Chessman.车, Chessman.Ju) {
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
    Ma(Chessman.Ma, Chessman.Ma2) {
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
    Xiang(Chessman.Xiang, Chessman.Xiang2) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 23, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0),

            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(18, 0, 0, 0, 23, 0, 0, 0, 18),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 20, 0, 0, 0, 20, 0, 0)
        )
    },
    Shi(Chessman.Shi, Chessman.Shi2) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 23, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),

            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 23, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 20, 0, 20, 0, 0, 0)
        )
    },
    jiang(Chessman.Jiang, Chessman.帅) {
        override val valueMap: Array<IntArray> = arrayOf(
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0),
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0),
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),

            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0),
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0),
            intArrayOf(0, 0, 0, 8888, 8888, 8888, 0, 0, 0)
        )
    },
    Pao(Chessman.Pao, Chessman.Pao2) {
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
    Zu(Chessman.Zu, Chessman.Bin) {
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

    abstract val valueMap: Array<IntArray>

    companion object {

        fun createFactory(): (Chessman) -> ChessmanEvaluator {
            val map = mutableMapOf<Chessman, ChessmanEvaluator>()
            values().forEach { evaluator ->
                evaluator.belongTo.forEach { chessman ->
                    map[chessman] = evaluator
                }
            }
            return { map[it]!! }
        }
    }
}

data class Position(val x: Int, val y: Int)
