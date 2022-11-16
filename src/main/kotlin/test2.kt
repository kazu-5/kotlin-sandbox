fun main() {
    val testA = Test("test1", "test2", TestParent("test2", "test1"))
    val testB = Test("test1", "test2", TestParent("test2", "test5"))
    println(testA.equals(testB))
}

data class TestParent(val value1: String, val value2: String)

data class Test(val value1: String, val value2: String, val parent: TestParent)
