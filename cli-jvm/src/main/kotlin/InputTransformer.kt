import com.github.kchess.algorithm.Chessman
import com.github.kchess.algorithm.ChineseChessBoard.Companion.COLUMN_SIZE

/**
 * @author YvesCheung
 * 2020/9/18
 */
val input = """
--+----+----+---黑士--黑帅--黑士--黑象---+----+--

--+----+----+----+----+----+----+----+----+--

--+----+----+----+---黑象---+----+----+----+--

--+----+----+----+---红炮--黑车---+----+---黑兵-

-黑兵---+----+----+----+----+---黑兵---+----+--

--+----+---黑兵---+----+----+----+----+----+--

--+----+----+----+----+----+----+---黑车--红卒-

--+----+----+----+---红象---+---红马--黑炮---+--

--+----+----+----+----+----+----+---红车---+--

--+----+---红象--红士--红将--红士---+----+----+--
""".trimIndent()

fun main() {
    val result = mutableListOf<Chessman?>()
    var i = 0
    while (i < input.length) {
        val c = input[i]
        if (c == '红' || c == '黑') {
            val name = c.toString() + input[i + 1]
            result.add(Chessman.valueOf(name))
            i++
        } else if (c == '+') {
            result.add(null)
        }
        i++
    }
    i = 0
    println("arrayOf<Array<Chessman?>>(")
    while (i < result.size) {
        if (i % COLUMN_SIZE == 0) {
            print("\t/*${i / COLUMN_SIZE}*/arrayOf(")
        }
        print("/*${i % COLUMN_SIZE}*/" + result[i])
        if ((i + 1) % COLUMN_SIZE != 0) {
            print(", ")
        } else {
            if (i == result.size - 1) println(")")
            else if (i != 0) println("),")
        }
        i++
    }
    println(")")
}
