package com.github.kchess.algorithm

import kotlin.js.JsName

/**
 * @author YvesCheung
 * 2020/9/30
 */
@Suppress("MemberVisibilityCanBePrivate")
abstract class Game {

    protected var gameOver = false

    protected open val listeners: Map<String, MutableList<(param: Array<Any>) -> Unit>> =
        listOf("reset", "over", "record").associateWith {
            @Suppress("RemoveExplicitTypeArguments")
            mutableListOf<(param: Array<Any>) -> Unit>()
        }

    /**
     * 当前可行动的玩家
     */
    @JsName("currentPlayer")
    var currentPlayer: OwnerShip = OwnerShip.Player1
        protected set

    /**
     * 是否已结束，无法再操作
     */
    @JsName("isGameOver")
    open fun isGameOver(): Boolean = gameOver

    /**
     * 添加事件监听
     *
     * ```
     * addEventListener("over", ([winner])=>{})
     * addEventListener("reset", ()=>{})
     * addEventListener("record", (Array<action>)=>{})
     * ```
     */
    @JsName("addEventListener")
    open fun addEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.add(callback)
    }

    /**
     * @see addEventListener
     */
    @JsName("removeEventListener")
    open fun removeEventListener(type: String, callback: (param: Array<Any>) -> Unit) {
        val typeListeners = listeners[type]
        typeListeners?.remove(callback)
    }
}
