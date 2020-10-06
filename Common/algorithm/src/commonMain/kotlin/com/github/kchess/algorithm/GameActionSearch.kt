package com.github.kchess.algorithm

/**
 *
 * @author YvesCheung
 * 2020/9/16
 */
abstract class GameActionSearch<Piece : Any, GameType : Game<Piece>> {

    fun alphaBetaSearch(depth: Int, context: GameType, player: OwnerShip = OwnerShip.Player2): GameSearchResult<Piece> {
        return alphaBetaSearch(
            depth,
            ALPHA,
            BETA,
            context,
            player,
            NO_TIMEOUT
        )
    }

    fun alphaBetaSearchWithTimeout(
        context: GameType,
        player: OwnerShip = OwnerShip.Player2,
        minDepth: Int = 2,
        maxDepth: Int = 10,
        timeout: Long = 5 * 1000L
    ): GameSearchResult<Piece> {
        if (timeout <= NO_TIMEOUT) {
            throw IllegalArgumentException("Timeout should be larger than 0")
        }
        val timeoutTimeStamp = currentTime() + timeout
        var depth = minDepth
        var lastResult: GameSearchResult<Piece> = alphaBetaSearch(depth, context, player)
        try {
            while (depth < maxDepth) {
                if (currentTime() > timeoutTimeStamp) break
                lastResult = alphaBetaSearch(++depth, ALPHA, BETA, context, player, timeoutTimeStamp)
            }
        } catch (e: TimeoutException) {
            //Do Nothing
        }
        return lastResult
    }

    private fun alphaBetaSearch(
        depth: Int,
        alpha: Int,
        beta: Int,
        context: GameType,
        player: OwnerShip,
        timeoutTimeStamp: Long
    ): GameSearchResult<Piece> {
        if (timeoutTimeStamp > NO_TIMEOUT && currentTime() > timeoutTimeStamp) {
            throw TimeoutException()
        }
        if (depth < 0) {
            throw IllegalArgumentException("depth must be >= 0, but actual value is $depth!")
        }
        if (depth == 0) {
            return GameSearchResult(null, evaluate(context, player), depth)
        }
        var maxAlpha = alpha
        var alphaAction: GameAction<Piece>? = null
        for (action in nextMove(context, depth, player)) {
            action.run(context)
            try {
                val result = alphaBetaSearch(depth - 1, -beta, -maxAlpha, context, -player, timeoutTimeStamp)
                val value = -result.evaluateValue
                if (value >= beta) {
                    return GameSearchResult(action, value, depth)
                }
                if (value > maxAlpha) {
                    maxAlpha = value
                    alphaAction = action
                }
            } finally {
                action.undo(context)
            }
        }
        return GameSearchResult(alphaAction, maxAlpha, depth)
    }

    abstract fun evaluate(context: GameType, player: OwnerShip): Int

    abstract fun nextMove(context: GameType, depth: Int, player: OwnerShip): Sequence<GameAction<Piece>>

    companion object {

        private const val NO_TIMEOUT = 0L

        private const val ALPHA = -Int.MAX_VALUE //Use -max instead of min because -min would overflow

        private const val BETA = Int.MAX_VALUE
    }
}
