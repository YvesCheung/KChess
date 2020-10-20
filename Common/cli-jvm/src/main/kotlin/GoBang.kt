import com.github.kchess.algorithm.OwnerShip
import com.github.kchess.algorithm.gobang.GoBang
import com.github.kchess.algorithm.gobang.GoBangSearch

/**
 * @author YvesCheung
 * 2020/10/7
 */
fun main() {
    val game = GoBang()
    val algorithm = GoBangSearch()
    var step = 20
    var player = OwnerShip.Player1
    while (step-- > 0 && !game.isGameOver()) {
        val action = algorithm.alphaBetaSearch(5, game, player)
        player = -player
        action.action?.run(game)

        println(action)
        println(game.gameBoard)
    }
}
