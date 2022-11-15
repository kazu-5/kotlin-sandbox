import kotlinx.coroutines.*

fun main() {
    val testB = Test6("test1","test2")
    println(testB.value2)
}

class Test6(value1:String, val value2:String){
    val value3 = value1
}