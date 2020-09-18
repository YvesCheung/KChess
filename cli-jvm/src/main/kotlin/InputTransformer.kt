import com.github.kchess.algorithm.Chessman
import com.github.kchess.algorithm.ChineseChessBoard.Companion.COLUMN_SIZE
import kotlin.text.StringBuilder

/**
 * @author YvesCheung
 * 2020/9/18
 */
class InputTransformer {

    fun main(input: String): String {
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
        val outputStr = StringBuilder()
        outputStr.append("arrayOf<Array<Chessman?>>(\n")
        while (i < result.size) {
            if (i % COLUMN_SIZE == 0) {
                outputStr.append("\t/*${i / COLUMN_SIZE}*/arrayOf(")
            }
            outputStr.append("/*${i % COLUMN_SIZE}*/" + result[i])
            if ((i + 1) % COLUMN_SIZE != 0) {
                outputStr.append(", ")
            } else {
                if (i == result.size - 1) outputStr.append(")\n")
                else if (i != 0) outputStr.append("),\n")
            }
            i++
        }
        outputStr.append(")")
        return outputStr.toString()
    }
}
