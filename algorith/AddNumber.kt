/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in 0 until nums.size - 1)
            for(j in i + 1 until nums.size)
                if(nums[i]+nums[j] == target)return intArrayOf(i,j)
        return intArrayOf()
    }
}