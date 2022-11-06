package leetcode.doublepointer


fun main() {
    println(Solution_18().fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
}

class Solution_18 {


    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        var index1 = 0
        if (nums.size < 4) {
            return result
        }
        nums.sort()
        if (getSumLong(nums[0], nums[1], nums[2], nums[3]) > target) {
            return result
        }
        while (index1 < nums.size - 2) {
            if (index1 + 3 <= nums.size - 1 && getSumLong(nums[index1], nums[index1 + 1], nums[index1 + 2], nums[index1 + 3]) > target) {
                //第一位确定，最小值大于目标值，直接返回结果
                return result
            }
            if (index1 < nums.size - 3 && getSumLong(nums[index1], nums[nums.size - 1], nums[nums.size - 2], nums[nums.size - 3]) < target) {
                //第一位确定，最大值小于目标值，跳过当前第一位固定的后续循环
                index1++
                continue
            }
            if (index1 - 1 >= 0 && nums[index1] == nums[index1 - 1]) {
                index1++  //和上一个相同
                continue
            }
            var index2 = index1 + 1
            while (index2 < nums.size - 1) {
                if (index2 + 2 <= nums.size - 1 && getSumLong(nums[index1], nums[index2], nums[index2 + 1], nums[index2 + 2]) > target) {
                    // 1，2位确定，最小值大于目标值，跳过第二位后续循环，继续第一位循环
                    break
                }
                if (index2 < nums.size - 2 && getSumLong(nums[index1], nums[index2], nums[nums.size - 1], nums[nums.size - 2]) < target) {
                    //1，2位确定，最大值小于目标值，跳过3.4位循环，继续第2位循环
                    index2++
                    continue
                }
                if (index2 - 1 > index1 && nums[index2] == nums[index2 - 1]) {
                    index2++  //和上一个相同
                    continue
                }
                // 对之后的数字使用双指针从两边向中间筛选
                var left = index2 + 1
                var right = nums.size - 1
                while (left < right) {
                    if (left - 1 > index2 && nums[left - 1] == nums[left]) {
                        left++
                        continue
                    }
                    if (right + 1 <= nums.size - 1 && nums[right + 1] == nums[right]) {
                        right--
                        continue
                    }
                    val sum = getSumLong(nums[index1], nums[index2], nums[left], nums[right])
                    if (target.toLong() == sum) {
                        result.add(arrayListOf(nums[index1], nums[index2], nums[left], nums[right]))
                    }
                    if (sum > target) {
                        right--
                    } else {
                        left++
                    }
                }
                index2++
            }
            index1++
        }
        return result
    }

    private fun getSumLong(a: Int, b: Int, c: Int, d: Int): Long = a.toLong() + b.toLong() + c.toLong() + d.toLong()

    //    val result = mutableListOf<List<Int>>()
//
//        fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
//        result.clear()
//        nums.sort()
//        var startIndex = 1
//        var lastStartIndex: Int? = null
//        var endIndex = startIndex + 1
//        var lastEndIndex: Int? = null
//        while (startIndex <= nums.size - 3) {
//            if (lastStartIndex != null && nums[startIndex] == nums[lastStartIndex]) {
//                lastStartIndex = startIndex
//                startIndex++
//                continue
//            }
//            endIndex = startIndex + 1
//            while (endIndex <= nums.size - 2) {
//                if (lastEndIndex != null && nums[endIndex] == nums[lastEndIndex]) {
//                    lastEndIndex = endIndex
//                    endIndex++
//                    continue
//                }
//                findSumCombination(nums, startIndex, endIndex, target)
//                lastEndIndex = endIndex
//                endIndex++
//            }
//            lastStartIndex = startIndex
//            startIndex++
//        }
//        return result
//    }
//
//    private fun findSumCombination(nums: IntArray, index1: Int, index2: Int, target: Int) {
//        var startIndex = index1 - 1
//        var lastStartIndex: Int? = null
//        var lastEndIndex: Int? = null
//        var endIndex = index2 + 1
//        while (startIndex >= 0 && endIndex <= nums.size - 1) {
//            if (lastStartIndex != null && nums[lastStartIndex] == nums[startIndex]) {
//                lastStartIndex = startIndex
//                startIndex-- // 防止重复
//                continue
//            }
//            if (lastEndIndex != null && nums[lastEndIndex] == nums[endIndex]) {
//                lastEndIndex = endIndex
//                endIndex++   // 防止重复
//                continue
//            }
//            if (nums[startIndex] + nums[index1] + nums[index2] + nums[endIndex] == target) {
//                result.add(arrayListOf(nums[startIndex], nums[index1], nums[index2], nums[endIndex]))
//            }
//            if (nums[startIndex] + nums[index1] + nums[index2] + nums[endIndex] <= target) {
//                lastEndIndex = endIndex
//                endIndex++
//            } else {
//                lastStartIndex = startIndex
//                startIndex--
//            }
//        }
//
//    }
}