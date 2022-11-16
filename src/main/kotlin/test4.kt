import java.time.LocalDate
import java.time.LocalDateTime

fun main() {
//    val test = OffsetDateTime.now()
//    println(test)
//    val test2: LocalDate = test as LocalDate
//    println(test2)

    val test = LocalDateTime.now()
    println(test)
    val test2: LocalDate = test as LocalDate
    println(test2)
}
