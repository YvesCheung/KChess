package com.github.kchess.algorithm

/**
 * @author YvesCheung
 * 2020/10/6
 */
expect fun currentTime(): Long

class TimeoutException : RuntimeException()
