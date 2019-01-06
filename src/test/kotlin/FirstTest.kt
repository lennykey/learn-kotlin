import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FirstTest {

    @Test
    fun first() {
        val stringRage = "A".."Y"
        //println("B" in stringRage)

        //println(stringRage.toString())
        //println(stringRage.endInclusive)

        val intRange = 1..7
        //println(8 in intRange)
        //intRange.forEach { println(it) }

        val charRange = 'a'..'x'
        //charRange.forEach{ println(it)}

        val r = 5..1
        r.forEach { println(it) }

        val backwardIntRange = 5.downTo(2)
        backwardIntRange.forEach { println(it) }

        for(item in 'A'..'F'){
            println(item)
            println(item::class)
        }

        val range = 1..5
        val reversedRange = range.reversed()
        reversedRange.forEach { println(it) }


        val goodBy = "goodBy"
        val sRange = 0..goodBy.length
        println(sRange)
    }

    @Test
    fun ifExpression(){
        val x = if (true) 5 else "five"

        assertTrue(x is Int)
        assertTrue(x is Any)
    }
}