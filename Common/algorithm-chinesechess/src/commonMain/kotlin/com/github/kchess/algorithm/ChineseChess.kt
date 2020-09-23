package com.github.kchess.algorithm

import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/16
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChess {

    private val moveSearch = ChineseChessSearch()

    private val actionRecord = mutableListOf<GameAction<ChineseChess>>()

    /**
     * 棋盘
     */
    val gameBoard = ChineseChessBoard()

    /**
     * 当前可行动的玩家
     */
    var currentPlayer: OwnerShip = OwnerShip.Player1
        private set

    /**
     * 进行一次棋子移动
     *
     * @param action 棋子移动
     * @param player 回合行动的玩家
     */
    @JsName("move")
    fun move(action: GameAction<ChineseChess>, player: OwnerShip = currentPlayer) {
        takeAction(action, player)
    }

    /**
     * 进行一次机器人的自动移动
     *
     * @param player 回合行动的玩家
     */
    @JsName("autoMove")
    fun autoMove(player: OwnerShip = currentPlayer) {
        val result =
            moveSearch.alphaBetaSearch(4, this, player)
        val action = result.action
        if (action != null) {
            takeAction(action, player)
        }
    }

    private fun takeAction(action: GameAction<ChineseChess>, player: OwnerShip) {
        action.run(this)
        actionRecord.add(action)
        currentPlayer = -player
    }

    /**
     * 悔棋
     *
     * @param recoverStep 回退步数
     */
    @JsName("regret")
    fun regret(recoverStep: Int = 2) {
        var step = recoverStep
        while (step-- > 0) {
            if (actionRecord.isEmpty()) {
                return
            }
            val action =
                actionRecord.removeAt(actionRecord.lastIndex)
            action.undo(this)
            currentPlayer = -currentPlayer
        }
    }

    /**
     * 获取目标棋子当前可以移动的坐标
     *
     * @param row 目标棋子所在行数
     * @param column 目标棋子所在的列数
     */
    @JsName("getIntentAction")
    fun getIntentAction(row: Int, column: Int): List<Position> {
        val chessman = this.gameBoard[row, column]
        if (chessman != null) {
            return ChessmanRule.nextMove(chessman, row, column, this).toList()
        }
        return emptyList()
    }
}


data class Position(val r: Int, val c: Int) {

    fun offset(offset: Position): Position = Position(r + offset.r, c + offset.c)
}
