import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author YvesCheung
 * 2020/9/18
 */
class InputTransformTest {

    private val input = """
--+----+----+---黑士--黑帅--黑士--黑象---+----+--

--+----+----+----+----+----+----+----+----+--

--+----+----+----+---黑象---+----+----+----+--

--+----+----+----+---红炮--黑车---+----+---黑卒-

-黑卒---+----+----+----+----+---黑卒---+----+--

--+----+---黑卒---+----+----+----+----+----+--

--+----+----+----+----+----+----+---黑车--红兵-

--+----+----+----+---红象---+---红马--黑炮---+--

--+----+----+----+----+----+----+---红车---+--

--+----+---红象--红士--红将--红士---+----+----+--
""".trimIndent()

    @Test
    fun test() {
        val output = InputTransformer().main(input)
        println(output)
        assertEquals("""
arrayOf<Array<Chessman?>>(
	/*0*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/黑士, /*4*/黑帅, /*5*/黑士, /*6*/黑象, /*7*/null, /*8*/null),
	/*1*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
	/*2*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/黑象, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
	/*3*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红炮, /*5*/黑车, /*6*/null, /*7*/null, /*8*/黑卒),
	/*4*/arrayOf(/*0*/黑卒, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/黑卒, /*7*/null, /*8*/null),
	/*5*/arrayOf(/*0*/null, /*1*/null, /*2*/黑卒, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/null, /*8*/null),
	/*6*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/黑车, /*8*/红兵),
	/*7*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/红象, /*5*/null, /*6*/红马, /*7*/黑炮, /*8*/null),
	/*8*/arrayOf(/*0*/null, /*1*/null, /*2*/null, /*3*/null, /*4*/null, /*5*/null, /*6*/null, /*7*/红车, /*8*/null),
	/*9*/arrayOf(/*0*/null, /*1*/null, /*2*/红象, /*3*/红士, /*4*/红将, /*5*/红士, /*6*/null, /*7*/null, /*8*/null)
)
        """.trimIndent(),
            output)
    }
}
