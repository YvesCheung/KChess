@file:Suppress("FunctionName", "unused", "RemoveRedundantQualifierName")

import com.github.kchess.algorithm.Chessman
import com.github.kchess.algorithm.ChineseChess

/**
 * 减少js代码调用kt时的包名声明
 *
 * @author YvesCheung
 * 2020/9/19
 */
@JsName("ChineseChess")
fun ChineseChess() = com.github.kchess.algorithm.ChineseChess()

@JsName("Action")
fun Action(
    chessman: Chessman,
    row: Int,
    column: Int,
    newRow: Int,
    newColumn: Int
) = com.github.kchess.algorithm.ChineseChessAction(chessman, row, column, newRow, newColumn)

@JsName("Position")
fun Position(r: Int, c: Int) = com.github.kchess.algorithm.Position(r, c)

@JsName("ChessBoard")
val ChessBoard = com.github.kchess.algorithm.ChineseChessBoard

@JsName("Controller")
fun Controller(game: ChineseChess) = com.github.kchess.algorithm.ChineseChessUiController(game)
