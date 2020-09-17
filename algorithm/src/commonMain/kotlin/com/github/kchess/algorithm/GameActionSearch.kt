package com.github.kchess.algorithm

/**
 *
 * @author YvesCheung
 * 2020/9/16
 */
abstract class GameActionSearch<Game : Any> {

    fun alphaBetaSearch(depth: Int, context: Game, player: OwnerShip = OwnerShip.Player2): GameSearchResult<Game> {
        return alphaBetaSearch(
            depth,
            -Int.MAX_VALUE, //Use -max instead of min because -min would overflow
            Int.MAX_VALUE,
            context,
            player
        )
    }

    private fun alphaBetaSearch(
        depth: Int,
        alpha: Int,
        beta: Int,
        context: Game,
        player: OwnerShip
    ): GameSearchResult<Game> {
        if (depth < 0) {
            throw IllegalArgumentException("depth must be >= 0, but actual value is $depth!")
        }
        if (depth == 0) {
            return GameSearchResult(null, evaluate(context, player))
        }
        var maxAlpha = alpha
        var alphaAction: GameAction<Game>? = null
        for (action in nextMove(context, player)) {
            action.run(context)
            val result = alphaBetaSearch(depth - 1, -beta, -maxAlpha, context, -player)
            val value = -result.evaluateValue
            action.undo(context)
            if (value >= beta) {
                return GameSearchResult(action, value)
            }
            if (value > maxAlpha) {
                maxAlpha = value
                alphaAction = action
            }
        }
        return GameSearchResult(alphaAction, maxAlpha)
    }

    abstract fun evaluate(context: Game, player: OwnerShip): Int

    abstract fun nextMove(context: Game, player: OwnerShip): Sequence<GameAction<Game>>
}
