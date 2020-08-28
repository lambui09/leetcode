import javax.lang.model.element.Element

interface OnStack<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek()  : Element?
    val count : Int
    get
    val isEmpty: Boolean
    get() = count == 0

}