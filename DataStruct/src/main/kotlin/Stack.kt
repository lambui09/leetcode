import javax.lang.model.element.Element

fun main() {
    val stack = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
    }
    println(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null) {
        println("Popped : $poppedElement")
    }
    println(stack)

    //init stack
    val list = listOf("A", "B", "C", "D")
    val stackA = Stack.create(list)
}

class Stack<T : Any>() : OnStack<T> {
    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override fun push(element: T) {
        storage.add(element)
    }

    private val lam: Any? = null

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        append("---Top---")
        storage.asReversed().forEach {
            println("$it")
        }
        println("---Top---")
    }

    companion object {
        fun <Element> create(items: Iterable<Element>): Stack<Any> {
            val stack = Stack<Any>()
            for (item in items) {
                stack.push(item as javax.lang.model.element.Element)
            }
            return stack
        }
    }
}

