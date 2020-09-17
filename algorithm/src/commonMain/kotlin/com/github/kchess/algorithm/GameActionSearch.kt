package com.github.kchess.algorithm

/**
 *
 * @author YvesCheung
 * 2020/9/16
 */
abstract class GameActionSearch<Game : Any> {

    fun alphaBetaSearch(depth: Int, context: Game): GameSearchResult<Game> {
        return alphaBetaSearch(depth, Int.MIN_VALUE, Int.MAX_VALUE, context, false)
    }

    private fun alphaBetaSearch(
        depth: Int,
        alpha: Int,
        beta: Int,
        context: Game,
        turn: Boolean = false
    ): GameSearchResult<Game> {
        if (depth < 0) {
            throw IllegalArgumentException("depth must be >= 0, but actual value is $depth!")
        }
        if (depth == 0) {
            return GameSearchResult(null, evaluate(context))
        }
        var maxAlpha = alpha
        var alphaAction: GameAction<Game>? = null
        for (action in nextMove(context, turn)) {
            action.run(context)
            val result = alphaBetaSearch(depth - 1, -beta, -maxAlpha, context, !turn)
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

    abstract fun evaluate(context: Game): Int

    abstract fun nextMove(context: Game, simulateTurn: Boolean): Sequence<GameAction<Game>>
}
