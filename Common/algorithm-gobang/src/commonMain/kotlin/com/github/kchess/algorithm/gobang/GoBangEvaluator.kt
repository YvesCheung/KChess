package com.github.kchess.algorithm.gobang

import com.github.kchess.algorithm.GameBoard
import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.Position
import com.github.kchess.algorithm.TestOnly
import com.github.kchess.algorithm.gobang.GoBang.Companion.PIECE_IN_ROW
import com.github.kchess.algorithm.gobang.GoBangEvaluator.Vector.LEFT
import com.github.kchess.algorithm.gobang.GoBangEvaluator.Vector.LEFT_TOP
import com.github.kchess.algorithm.gobang.GoBangEvaluator.Vector.RIGHT_TOP
import com.github.kchess.algorithm.gobang.GoBangEvaluator.Vector.TOP
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

/**
 * @author YvesCheung
 * 2020/10/6
 */
@Suppress("MemberVisibilityCanBePrivate")
object GoBangEvaluator {

    fun evaluate(context: GoBang, player: OwnerShip): Int {
        val evaluateBoard = transform(context.gameBoard)
        return evaluateBoard.fold(0) { acc, (vector4d, row, column) ->
            val v = vector4d?.evaluateValue ?: 0
            if (context.gameBoard[row, column] belongsTo player) {
                acc + v
            } else {
                acc - v
            }
        }
    }

    fun transform(gameBoard: GoBangGameBoard): Matrix {
        val calculate = Matrix(gameBoard.rowSize, gameBoard.columnSize)

        gameBoard.forEach { (piece, row, column) ->
            if (piece != null) {
                for (orientation in Vector.values()) {
                    val current = calculate[row, column]!!
                    val currentData = current.of(orientation)

                    val previousPosition = orientation.previousPos(row, column)
                    val previous = calculate[previousPosition]
                    val previousPiece = gameBoard[previousPosition]
                    if (previous == null /*edge of the gameBoard*/ ||
                        previousPiece == piece.opponent() /*next to the enemy*/) {
                        //current is the first piece in a line
                        currentData.pieceInLine = 1
                        currentData.isBlocked = ONE_BLOCK
                    } else {
                        val previousData = previous.of(orientation)
                        if (previousPiece == piece) { //has same piece in a line
                            currentData.pieceInLine = previousData.pieceInLine + 1
                            currentData.isBlocked = previousData.isBlocked
                        } else { //No previous piece, current is the first piece in a line
                            currentData.pieceInLine = 1
                            currentData.isBlocked = NO_BLOCK
                        }
                    }

                    val nextPosition = orientation.nextPos(row, column)
                    val nextPiece = gameBoard[nextPosition]
                    if (!gameBoard.contains(nextPosition) /*edge of the gameBoard*/ ||
                        nextPiece == piece.opponent() /*next to the enemy*/) {
                        currentData.evaluatePoint = true
                        currentData.isBlocked++ //NO_BLOCK -> ONE_BLOCK or ONE_BLOCK -> TWO_BLOCK
                    }
                }
            }
        }
        return calculate
    }

    @TestOnly
    class Matrix internal constructor(val rowSize: Int, val columnSize: Int) : GameBoard<Vector4d>() {

        init {
            reset()
        }

        override fun reset() {
            @Suppress("RemoveExplicitTypeArguments")
            gameBoard = Array(rowSize) { Array<Vector4d?>(columnSize) { Vector4d() } }
        }

        override fun toString(): String = gameBoard.joinToString(separator = "\n") { array ->
            array.joinToString { value -> (value?.maxPieceInLine ?: 0).toString() }
        }
    }

    //Four direction '米'
    @TestOnly
    class Vector4d : Map<Vector, VectorData> by mapOf(
        TOP to VectorData(),
        LEFT to VectorData(),
        LEFT_TOP to VectorData(),
        RIGHT_TOP to VectorData()
    ) {
        fun of(vector: Vector): VectorData = this[vector]!!

        val maxPieceInLine: Int
            get() = values.fold(0) { acc, vectorData -> max(acc, vectorData.pieceInLine) }

        val evaluateValue: Int
            get() = values.fold(0) { acc, vectorData -> max(acc, vectorData.evaluateValue) }
    }

    @TestOnly
    data class VectorData internal constructor(
        var pieceInLine: Int = 0, //how many my piece in line
        var isBlocked: Int = NO_BLOCK, //whether opponent had taken the head
        var evaluatePoint: Boolean = false //is the last piece in line
    ) {

        val evaluateValue: Int
            get() = if (evaluatePoint) when (isBlocked) {
                TWO_BLOCK -> 0
                ONE_BLOCK -> pieceInLineEvaluateValue / 2
                else -> pieceInLineEvaluateValue
            } else 0

        private val pieceInLineEvaluateValue: Int
            get() = 10.0.pow(min(pieceInLine, PIECE_IN_ROW)).toInt()
    }

    @TestOnly
    enum class Vector(val preRowOffset: Int, val preColumnOffset: Int, val nextRowOffset: Int, val nextColumnOffset: Int) {
        LEFT(0, -1, 0, 1),
        TOP(-1, 0, 1, 0),
        LEFT_TOP(-1, -1, 1, 1),
        RIGHT_TOP(-1, 1, 1, -1);

        fun previousPos(row: Int, column: Int): Position = Position(row + preRowOffset, column + preColumnOffset)

        fun nextPos(row: Int, column: Int): Position = Position(row + nextRowOffset, column + nextColumnOffset)
    }


    const val NO_BLOCK = 0
    const val ONE_BLOCK = 1
    const val TWO_BLOCK = 2
}
