import com.github.kchess.algorithm.*

/**
 * @author YvesCheung
 * 2020/9/17
 */
fun main() {
    val game = ChineseChess()
    printChessBoard(game.gameBoard)

    val algorithm = ChineseChessSearch()
    var player = OwnerShip.Player1
    var n = 8
    while (n-- > 0) {
        val result =
            algorithm.alphaBetaSearch(5, game, player)
        val action = result.action ?: break
        action.run(game)
        println("$player: $action")
        printChessBoard(game.gameBoard)
        player = -player
    }
}

private fun printChessBoard(board: ChineseChessBoard) {
    board.forEachNullable { chessman, newLine, _, _ ->
        if (newLine) {
            println()
            println()
        }
        if (chessman != null) print(chessman(chessman)) else print(noChessman())
    }
    println()
}

const val ANSI_RESET = "\u001B[0m"
const val ANSI_RED = "\u001B[31m"
const val ANSI_BLUE = "\u001B[34m"

fun chessman(c: Chessman) = "-${if (!c.owner) ANSI_BLUE else ANSI_RED}${c.name}$ANSI_RESET-"

fun noChessman() = "--+--"
