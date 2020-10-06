package com.github.kchess.algorithm.chinesechess

import com.github.kchess.algorithm.GamePieceWithPosition
import com.github.kchess.algorithm.OwnerShip
import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/23
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class ChineseChessUiController(val game: ChineseChess) {

    private var selectedTarget: GamePieceWithPosition<Chessman>? = null

    private var render: ((renderFinish: () -> Unit) -> Unit)? = null

    @JsName("click")
    fun click(row: Int, column: Int, player: OwnerShip = game.currentPlayer) {
        if (player != game.currentPlayer) return //不是该玩家的回合

        var shouldAutoMove = false

        val selectTarget = selectedTarget
        val clickTarget = game.gameBoard[row, column]
        if (clickTarget?.owner == player) { //重新选了自己的另外的一个棋子
            selectedTarget = GamePieceWithPosition(
                clickTarget,
                false,
                row,
                column
            )
        } else if (selectTarget != null) { //已经有选中的棋子
            val canMove =
                game.getIntentAction(selectTarget.row, selectTarget.column)
            val canMoveToTarget =
                canMove.find { it.row == row && it.column == column }
            if (canMoveToTarget != null) {
                println("Can move to $canMoveToTarget")
                game.move(
                    ChineseChessAction(
                        selectTarget,
                        canMoveToTarget.row,
                        canMoveToTarget.column
                    )
                )
                shouldAutoMove = true
            } else {
                println("Can't move to ($row, $column)")
            }
        }

        val afterRender = {
            if (shouldAutoMove) {
                selectedTarget = null
                game.autoMove()
                render?.invoke(DoNothing)
            }
        }
        render?.invoke(afterRender)
    }

    @JsName("getRenderDecorate")
    fun getRenderDecorate(row: Int, column: Int): Array<Decorate> {
        val selectTarget = selectedTarget
        if (selectTarget != null &&
            selectTarget.row == row && selectTarget.column == column
        ) {
            return if (selectTarget.chessman.owner.toBoolean())
                arrayOf(Decorate.Player1Select)
            else
                arrayOf(Decorate.Player2Select)
        }

        val lastAction = game.actionRecord().lastOrNull()
        if (lastAction is ChineseChessAction) {
            if (lastAction.row == row && lastAction.column == column) {
                return if (lastAction.chessman.owner.toBoolean())
                    arrayOf(Decorate.Player1From)
                else
                    arrayOf(Decorate.Player2From)
            }
            if (lastAction.newRow == row && lastAction.newColumn == column) {
                return if (lastAction.chessman.owner.toBoolean())
                    arrayOf(Decorate.Player1To)
                else
                    arrayOf(Decorate.Player2To)
            }
        }
        return emptyArray()
    }

    @JsName("onRenderFrame")
    fun onRenderFrame(callback: ((renderFinish: () -> Unit) -> Unit)?) {
        render = callback
    }

    enum class Decorate {
        /**
         * 红方移动棋子，棋子的原位置
         */
        Player1From,

        /**
         * 红方移动棋子，棋子的新位置
         */
        Player1To,

        /**
         * 黑方移动棋子，棋子的原位置
         */
        Player2From,

        /**
         * 黑方移动棋子，棋子的新位置
         */
        Player2To,

        /**
         * 红方选中的棋子
         */
        Player1Select,

        /**
         * 黑方选中的棋子
         */
        Player2Select
    }

    companion object {

        private val DoNothing: () -> Unit = {}
    }
}
