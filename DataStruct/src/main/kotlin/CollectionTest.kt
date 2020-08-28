fun main() {
    var size = 0

}

class LinkedListT<T> {


    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedListT<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            println("vao day tail null")
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedListT<T> {
        //1:check mang rong
        if (isEmpty()) {
            push(value)
        }
        //2: bt
        tail?.next = Node(value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insertIndex(value: T, index: Int): Node<T> {
//        if (isEmpty()){
//            push(value)
//        }
        val afterNode = nodeAt(index)
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode?.next)
        afterNode?.next = newNode
        return newNode
    }
}