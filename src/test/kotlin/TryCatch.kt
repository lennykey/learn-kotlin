import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TryCatch {

    @Test
    fun shouldReturnValueFromTheTryBlock() {
        val tryCatchValue = convertFromStringToInt("5")
        Assertions.assertEquals(5, tryCatchValue)
    }

    @Test
    fun shouldReturnValueFromTheCatchBlock() {
        val tryCatch = convertFromStringToInt("55.55")
        Assertions.assertEquals(0, tryCatch)
    }

    @Test
    fun shouldReturnException() {
        Assertions.assertThrows(NumberFormatException::class.java) {
            val str = "5.5"
            try {
                Integer.parseInt(str)
            } finally {
                println("Finally Block")
            }
        }
    }

    private fun convertFromStringToInt(from: String): Int {
        return try {
            println("Try")
            Integer.parseInt(from) // this value will be returned if everything goes fine
        } catch (e: Exception) {
            println("Catch")
            0 // this value will be returned if an exception happens
        } finally {
            println("Finally printed at the end")
            // the finally block does not return any value and is not involved in the evaluation
        }
    }
}