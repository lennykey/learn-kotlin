import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Lists {

    @Test
    fun immutableList() {
        // This kind of list is immutable only using it in Kotlin
        // In Kotlin only immutable methods of the underlying class are available
        // The usage of immutable list passed to a Java Class is mutable
        val strings = listOf("John", "Joe", "Jane") // class java.util.Arrays$ArrayList
        Assertions.assertEquals("class java.util.Arrays\$ArrayList", strings.javaClass.toString())

    }

    @Test
    fun emptyList() {
        // This will create an empty list of the provided type
        // This type is not backed up with a Java Class
        val empty = emptyList<String>()
        Assertions.assertEquals("class kotlin.collections.EmptyList", empty.javaClass.toString())

        // Getting an object from an empty list leads to an IndexOutOfBoundsException
        Assertions.assertThrows(IndexOutOfBoundsException::class.java) {
            empty[0]
        }
    }

    @Test
    fun notNullList() {
        // This method will create a list which does not contain null values
        val notNullList = listOfNotNull("Hello", null, "World")

        Assertions.assertEquals(listOf("Hello", "World"), notNullList)
    }

    @Test
    fun mutableList() {
        // This method will return a java.util.ArrayList
        val mutable = arrayListOf("Hello", "World")
        Assertions.assertEquals("class java.util.ArrayList", mutable.javaClass.toString())

        // This method will also return a java.util.ArrayList
        val alsoMutable = mutableListOf("Hello", "World")
        Assertions.assertEquals("class java.util.ArrayList", alsoMutable.javaClass.toString())
    }

    @Test
    fun createAndConvertAnArray(){
        val array = arrayOf("Hello", "World")

        // Creating a list using asList()
        val arrayList = array.asList()
        Assertions.assertEquals(listOf("Hello", "World"), arrayList)

        // Creating a list using toList()
        val arrayListTwo = array.toList()
        Assertions.assertEquals(listOf("Hello", "World"), arrayListTwo)

        // Creating a list using the spread operator
        val arrayListThree = listOf(*array)
        Assertions.assertEquals(listOf("Hello", "World"), arrayListThree)
    }

}