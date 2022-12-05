package leetcode.binarysearch

fun main() {
    print(Solution_35().searchInsert(intArrayOf(1, 3, 5, 6), 2))
}

class Solution_35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target, 0, nums.size - 1)
    }

    fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (left == right) {
            if (nums[left] < target) {
                return left + 1
            } else return left

        }
        val mid = (left + right) / 2
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right)
        } else {
            return binarySearch(nums, target, left, mid)
        }
    }
}