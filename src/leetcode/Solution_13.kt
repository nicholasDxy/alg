package leetcode

/**
 * 13. 罗马数字转整数
 */

fun main() {
    println(Solution_13().romanToInt("MCMXCIV"))
}

class Solution_13 {

    private val map = mapOf<String, Int>(
            "M" to 1000,
            "D" to 500,
            "C" to 100,
            "L" to 50,
            "X" to 10,
            "V" to 5,
            "I" to 1
    )

    fun romanToInt(s: String): Int {
        var result = 0
        var curNum: Int? = 0
        var nextNum: Int? = 0
        var index = 0
        while (index < s.length) {
            curNum = map[s[index].toString()] ?: 0
            if (index < s.length - 1) {
                nextNum = map[s[index + 1].toString()] ?: 0
                if (nextNum > curNum) {
                    result += nextNum - curNum
                    index += 2
                    continue
                }
            }
            result += curNum
            index++
        }
        return result
    }
}