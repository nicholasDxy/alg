package leetcode.slidingwindow

import java.util.*

fun main() {
    val s = "cbaebabacd"
    val p = "abc"
    print(Solution_438().findAnagrams(s,p))
}
class Solution_438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = arrayListOf<Int>()
        if (s.length < p.length) {
            return result
        }
        val letterList = IntArray(26)
        for (letter in p) {
            val index = letter - 'a'
            letterList[index]++
        }
        val curWindowCount = IntArray(26)
        var left = 0
        var right = p.length - 1
        for (i in left until right + 1) {
            val index = s[i] - 'a'
            curWindowCount[index]++
        }
        if (Arrays.equals(letterList, curWindowCount)) {
            result.add(left)
        }
        left++
        right++
        while (right < s.length) {
            curWindowCount[s[left - 1] - 'a']--
            curWindowCount[s[right] - 'a']++
            if (Arrays.equals(letterList, curWindowCount)) {
                result.add(left)
            }
            left++
            right++
        }
        return result
    }

    fun ifListSame(array1: IntArray, array2: IntArray): Boolean {
        for (index in array1.indices) {
            if (array2[index] != array1[index]) {
                return false
            }
        }
        return true
    }
}