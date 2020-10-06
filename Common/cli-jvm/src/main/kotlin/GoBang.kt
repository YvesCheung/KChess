import com.github.kchess.algorithm.gobang.GoBang

/**
 * @author YvesCheung
 * 2020/10/7
 */
fun main() {
    val game = GoBang()
    var step = 8
    while (step-- > 0) {
        game.autoMove()

        println(game.gameBoard)
    }
}
