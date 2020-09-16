package com.github.kchess.algorithm

/**
 *
 * @author YvesCheung
 * 2020/9/16
 */
abstract class GameActionSearch<Game : Any> {

    fun alphaBetaSearch(depth: Int, context: Game): GameSearchResult<Game> {
        if (depth <= 0) {
            throw IllegalArgumentException("depth must be > 0, but actual value is $depth!")
        }
        var alpha = Int.MIN_VALUE
        val beta = Int.MAX_VALUE
        var alphaAction: GameAction<Game>? = null
        for (action in nextMove(context, false)) {
            action.run(context)
            val value = -alphaBetaSearchValue(depth - 1, -beta, -alpha, true, context)
            action.undo(context)
            if (value >= beta) {
                return GameSearchResult(action, value)
            }
            if (value > alpha) {
                alpha = value
                alphaAction = action
            }
        }
        return GameSearchResult(alphaAction, alpha)
    }

    private fun alphaBetaSearchValue(depth: Int, alpha: Int, beta: Int, simulateTurn: Boolean, context: Game): Int {
        if (depth < 0) {
            throw IllegalArgumentException("depth must be >= 0, but actual value is $depth!")
        }
        if (depth == 0) {
            return evaluate(context)
        }
        var maxAlpha = alpha
        for (action in nextMove(context, simulateTurn)) {
            action.run(context)
            val result = -alphaBetaSearchValue(depth - 1, -beta, -maxAlpha, !simulateTurn, context)
            action.undo(context)
            if (result >= beta) {
                return beta
            }
            if (result > maxAlpha) {
                maxAlpha = result
            }
        }
        return maxAlpha
    }

    abstract fun evaluate(context: Game): Int

    abstract fun nextMove(context: Game, simulateTurn: Boolean): Iterable<GameAction<Game>>
}
