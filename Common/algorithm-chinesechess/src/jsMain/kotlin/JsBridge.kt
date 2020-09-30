@file:Suppress("FunctionName", "unused", "RemoveRedundantQualifierName")

import com.github.kchess.algorithm.GameAction
import com.github.kchess.algorithm.chinesechess.Chessman
import com.github.kchess.algorithm.chinesechess.ChineseChess
import com.github.kchess.algorithm.chinesechess.ChineseChessAction
import com.github.kchess.algorithm.chinesechess.ChineseChessBoard
import com.github.kchess.algorithm.chinesechess.ChineseChessUiController

/**
 * 减少js代码调用kt时的包名声明
 *
 * @author YvesCheung
 * 2020/9/19
 */
@JsName("ChineseChess")
fun ChineseChess() = ChineseChess()

@JsName("Action")
fun Action(
    chessman: Chessman,
    row: Int,
    column: Int,
    newRow: Int,
    newColumn: Int
): GameAction<ChineseChess> = ChineseChessAction(
    chessman,
    row,
    column,
    newRow,
    newColumn
)

@JsName("Position")
fun Position(r: Int, c: Int) = com.github.kchess.algorithm.Position(r, c)

@JsName("ChessBoard")
val ChessBoard = ChineseChessBoard

@JsName("Controller")
fun Controller(game: ChineseChess) = ChineseChessUiController(game)
