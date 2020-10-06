package com.github.kchess.algorithm

import kotlin.js.Date

/**
 * @author YvesCheung
 * 2020/10/6
 */
actual fun currentTime(): Long = Date().getTime().toLong()
