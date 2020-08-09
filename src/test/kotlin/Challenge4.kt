import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Challenge4 {

    @Test
    @DisplayName("Print range from 5 to 5000 in steps of 5")
    fun challenge1() {
        var counter = 0

        for (i in 5..5000 step 5) {
            counter += 1
            println(i)
        }

        Assertions.assertEquals(1000, counter)
    }

    @Test
    @DisplayName("Print values from -500 to 0")
    fun challenge2() {
        var counter = 0

        for (i in -500..0) {
            counter += 1
            println(i)
        }

        Assertions.assertEquals(501, counter)
    }

    @Test
    @DisplayName("Print 15 values of the Fibonacci sequence")
    fun challenge3() {

        var first = 1
        var second = 1
        // Doesn´t have to be initialized until the first usage
        // If not there will be a compiler error
        var result: Int
        var counter = 2

        println(0)
        println(1)
        for (i in 1..13) {
            result = first + second
            first = second
            second = result

            println(result)
            counter += 1
        }

        Assertions.assertEquals(15, counter)
    }

    @Test
    @DisplayName("Print in 3 loops following output 1, 11, 100, 99, 98, 2")
    fun challenge4() {

        val expected = mutableListOf(1, 11, 100, 99, 98, 2)
        val against = mutableListOf<Int>()

        first@ for (i in 1..5) {
            println(i)
            against.add(i)
            if (i == 2) break
            for (j in 11..20) {
                println(j)
                against.add(j)
                for (k in 100 downTo 90) {
                    println(k)
                    against.add(k)
                    if (k == 98) continue@first
                }
            }
        }

        Assertions.assertEquals(expected, against)
    }

    @Test
    fun challenge5() {

        val num = 400
        val dnum = when {
            num < 100 -> -234.567
            num > 100 -> 444.555
            else -> 0.0
        }

        Assertions.assertEquals(444.555, dnum)
    }
}
