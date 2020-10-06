package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameBoard
import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.TestOnly
import kotlin.math.pow

/**
 * @author YvesCheung
 * 2020/10/6
 */
@Suppress("MemberVisibilityCanBePrivate")
object GoBangEvaluator {

    fun evaluate(context: GoBang, player: OwnerShip): Int {
        val evaluateBoard = transform(context.gameBoard)
        return evaluateBoard.fold(0) { acc, (evaluateValue, _, row, column) ->
            val v = evaluateValue?.max ?: 0
            if (context.gameBoard[row, column] belongsTo player) {
                acc + normalize(v)
            } else {
                acc - normalize(v)
            }
        }
    }

    private fun normalize(v: Int) = if (v == 0) 0 else 10.0.pow(v).toInt()

    fun transform(gameBoard: GoBangGameBoard): IntBoard {
        val calculate = IntBoard(gameBoard.rowSize, gameBoard.columnSize)

        gameBoard.forEach { (piece, _, row, column) ->
            if (piece != null) {
                val left = pieceInLine(gameBoard, calculate, piece, row, column - 1) { it.horizontal }
                val top = pieceInLine(gameBoard, calculate, piece, row - 1, column) { it.vertical }
                val leftTop = pieceInLine(gameBoard, calculate, piece, row - 1, column - 1) { it.leftTop }
                val rightTop = pieceInLine(gameBoard, calculate, piece, row - 1, column + 1) { it.rightTop }
                calculate[row, column] = Direction(left, top, leftTop, rightTop)
            }
        }
        return calculate
    }

    private inline fun pieceInLine(
        gameBoard: GoBangGameBoard,
        calculate: IntBoard,
        piece: Pieces,
        r: Int, c: Int,
        orientation: (Direction) -> Int
    ): Int =  //has adjacent piece
        if (gameBoard[r, c] == piece) (calculate[r, c]?.let(orientation) ?: 0) + 1 else 1


    @TestOnly
    class IntBoard internal constructor(val rowSize: Int, val columnSize: Int) : GameBoard<Direction>() {

        init {
            reset()
        }

        override fun reset() {
            gameBoard = Array(rowSize) { arrayOfNulls<Direction?>(columnSize) }
        }

        override fun equals(other: Any?): Boolean {
            return if (other is IntBoard) gameBoard.contentDeepEquals(other.gameBoard)
            else false
        }

        override fun hashCode(): Int = gameBoard.hashCode()

        override fun toString(): String = gameBoard.joinToString(separator = "\n") { array ->
            array.joinToString { value -> (value?.max ?: 0).toString() }
        }
    }

    //Four direction '米'
    @TestOnly
    data class Direction internal constructor(
        val horizontal: Int = 0, /* - */
        val vertical: Int = 0, /* | */
        val leftTop: Int = 0, /* \ */
        val rightTop: Int = 0 /* / */
    ) {
        val max: Int = max(this.horizontal, this.vertical, this.rightTop, this.leftTop)

        private fun max(vararg num: Int): Int = num.reduce { acc, i -> kotlin.math.max(acc, i) }
    }
}
