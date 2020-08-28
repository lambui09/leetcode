data class MyObject(
    val name: String,
    val code: String,
    val version: Int
)

fun main() {
    val objects = listOf(
        MyObject("Book1", "code_A", 2),
        MyObject("Book1", "code_A", 1),
        MyObject("Book2", "code_B", 3),
        MyObject("Book2", "code_B", 2),
        MyObject("Book2", "code_B", 1),
        MyObject("Book3", "code_C", 1)
        )

    val result = objects
        .groupingBy { it.code }
        .reduce { _, a, b -> maxOf(a, b, compareBy { it.version }) }
        .values
    print(result.joinToString(separator = "\n"))
}