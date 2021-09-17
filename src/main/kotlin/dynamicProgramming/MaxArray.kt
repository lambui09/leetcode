package dynamicProgramming

object MaxArray {
    fun maxSubArray(nums: IntArray): Int {
        var maxTemp = nums[0]
        var max = nums[0]
        if (nums.size == 1) {
            return nums[0]
        }
        nums.mapIndexed { index, i ->
            println("value---: ${i}")
            if (index > 0){
                maxTemp = maxOf(i+ maxTemp, i)
                max = maxOf(maxTemp, max)
                println("max----${max}")
            }

        }
        return max
    }
}