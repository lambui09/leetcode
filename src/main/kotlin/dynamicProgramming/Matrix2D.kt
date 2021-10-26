package dynamicProgramming

object Matrix2D {
    inline fun <reified T> matrix(height: Int, width: Int, initialize: () -> T) = Array(height) {
        Array(width) {
            initialize()
        }
    }

    val board = matrix(5, 5) {
        0
    }

    fun matrix() {
        board.forEach { row ->
            row.forEach { column ->
                print("${column} ")
            }
            print("|\n")
        }

    }
}