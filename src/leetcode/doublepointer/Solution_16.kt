package leetcode.doublepointer

import kotlin.math.abs


fun main() {
    println(Solution_16().threeSumClosest(intArrayOf(0,3,97,102,200), 300))
}

class Solution_16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = nums[0] + nums[1] + nums[2]
        for (index in 1..nums.size - 2) {
            val temp = findSumClosest(nums, target, index)
            if (temp == target) {
                return temp
            } else if (abs(temp - target) < abs(result - target)) {
                result = temp
            }
        }
        return result
    }

    fun findSumClosest(nums: IntArray, target: Int, midIndex: Int): Int {
        var startIndex = midIndex - 1
        var endIndex = midIndex + 1
        var result = nums[midIndex] + nums[startIndex] + nums[endIndex]
        while (startIndex >= 0 && endIndex <= nums.size - 1) {
            val temp = nums[midIndex] + nums[startIndex] + nums[endIndex]
            if (temp == target) {
                return temp
            }
            if (abs(temp - target) < abs(result - target)) {
                // 更接近
                result = temp
            }
            if (temp < target) {
                endIndex++
            } else {
                startIndex--
            }
        }
        return result
    }

//    fun abs(a: Int) = if (a >= 0) a else -a
}