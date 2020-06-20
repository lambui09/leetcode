/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun reverseInParentheses(inputString: String): String {
    val listValue = inputString.split('(').map{
        it -> it.trim()
    }
    listValue.forEach{
        it -> println(it)
    }
    return ""
}
fun main() {
    var input = "foo(bar)baz(blim)"
    reverseInParentheses(input)
}