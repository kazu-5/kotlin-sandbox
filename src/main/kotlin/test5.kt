import kotlinx.coroutines.*

fun main() {
    val test = Test5("12","34")
    test.hashCode()
    println(test.hashCode())
    val test2 = test.copy()
    println(test2.hashCode())
}


data class Test5(val value1:String, val value2:String?)