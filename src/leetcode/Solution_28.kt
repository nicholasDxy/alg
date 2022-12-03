package leetcode

/**
 * KMP
 */

fun main() {
    print(Solution_28().strStr("qqqqqq", "ccq"))
}

class Solution_28 {

    fun strStr(haystack: String, needle: String): Int {
//        val nextArrayq = getNextArray(needle)
        val nextArray = getIntArrayIterate(needle)
        var index1 = 0
        var index2 = 0
        while (index1 < haystack.length && index2 < needle.length) {
            if (index2 == -1 || haystack[index1] == needle[index2]) {
                index1++
                index2++
            } else {
                index2 = nextArray[index2]
            }
        }
        if (index2 >= needle.length) {
            return index1 - needle.length
        }
        return -1
    }

    fun getNextArray(needle: String): IntArray {
        val nextArray = IntArray(needle.length)
        for (index in needle.indices) {
            if (index == 0) {
                nextArray[index] = -1
            } else {
                nextArray[index] = findNext(index, needle)
            }
        }
        return nextArray
    }

    /**
     * 寻找当前下标的next
     */
    fun findNext(index: Int, needle: String): Int {
        if (index < 0) {
            return -1
        }
        if (index == 0) {
            return -1
        }
        var lastNext = findNext(index - 1, needle)
        while (lastNext >= 0) {
            if (needle[lastNext] == needle[index - 1]) {
                return lastNext + 1
            } else {
                lastNext = findNext(lastNext, needle)
            }
        }
        return 0
    }

    fun getIntArrayIterate(needle: String): IntArray {
        val nextArray = IntArray(needle.length)
        nextArray[0] = -1
        var preIndex = 0
        var curIndex = 1
        while (curIndex < needle.length) {
            if (preIndex == -1 || needle[preIndex] == needle[curIndex]) {
                preIndex++
                curIndex++
                if (preIndex < needle.length && curIndex < needle.length) {
                    nextArray[curIndex] = preIndex
                }
            } else {
                preIndex = nextArray[preIndex]
            }
        }
        return nextArray
    }

}