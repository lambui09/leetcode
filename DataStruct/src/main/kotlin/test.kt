fun main() {
    println("hello")
    fun printCar(car: Car?) { val isCoupe = car?.run {
        (it.doors <= 2) }
//        if (isCoupe == true) {
//            println("Coupes are awesome")
//        }

    }
}
data class Car(
    var doors : Int = 0
)