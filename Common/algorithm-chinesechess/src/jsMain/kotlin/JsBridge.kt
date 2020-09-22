import com.github.kchess.algorithm.Chessman

/**
 * 减少js代码调用kt时的包名声明
 *
 * @author YvesCheung
 * 2020/9/19
 */
@JsName("ChineseChess")
fun ChineseChess() = com.github.kchess.algorithm.ChineseChess()

@JsName("ChineseChessAction")
fun ChineseChessAction(
    chessman: Chessman,
    row: Int,
    column: Int,
    newRow: Int,
    newColumn: Int
) = com.github.kchess.algorithm.ChineseChessAction(chessman, row, column, newRow, newColumn)
