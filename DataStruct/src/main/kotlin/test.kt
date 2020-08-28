fun main() {
    println("hello")
    fun printCar(car: Car?) {
        val isCoupe = car?.let {
            (it.doors <= 2)
        }
//        if (isCoupe == true) {
//            println("Coupes are awesome")
//        }

    }

    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    node1.next = node2
    node2.next = node3
    val list = LinkedList<Int>()
    list.push(1)
    list.push(2)
    list.append(5)
    println(list)
    //insert node
    for (i in 6..8){
        list.insertIndex(-1*i, 2)
    }
    println("After insert : $list")


}


data class Car(
    var doors: Int = 0
)

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T> {
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

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            println("vao day tail null")
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
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
        if (tail == afterNode){
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode?.next)
        afterNode?.next = newNode
        return newNode
    }


}