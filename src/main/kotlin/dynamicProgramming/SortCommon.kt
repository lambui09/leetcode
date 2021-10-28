package dynamicProgramming

object SortCommon {
    //linear search
    fun linearSearch(array: Array<Int>, n: Int, key: Int): Int {
        array.forEachIndexed { index, i ->
            if (array[index] == key) {
                return index
            }
        }
        return -1

    }

    fun binarySearch(array: Array<Int>, key: Int, s: Int, e: Int): Int {
        var left: Int = s
        var right: Int = e
        while (left <= right) {
            var mid = (s + e) / 2
            if (array[mid] == key) {
                return mid
            } else if (array[mid] < key) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}