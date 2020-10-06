package com.github.kchess.algorithm.util

/**
 * @author YvesCheung
 * 2020/9/25
 */
class ObservableList<E>(
    private val actual: MutableList<E> = mutableListOf(),
    private val onChange: (List<E>) -> Unit
) {

    val size: Int get() = actual.size

    fun isEmpty(): Boolean = actual.isEmpty()

    fun add(e: E): Boolean {
        val b = actual.add(e)
        onChange(actual)
        return b
    }

    fun removeLast(): E {
        val last = actual.removeAt(actual.lastIndex)
        onChange(actual)
        return last
    }

    fun clear() {
        actual.clear()
        onChange(actual)
    }

    fun toList(): List<E> = actual
}
