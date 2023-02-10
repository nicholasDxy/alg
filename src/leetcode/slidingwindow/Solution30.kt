package leetcode.slidingwindow

fun main() {
//    val s = "wordgoodgoodgoodbestword"
//    val words = arrayOf("word","good","best","good")
    val s = "ababababab"
    val words = arrayOf("ababa","babab")
    print(Solution30().findSubstring(s, words))
}

class Solution30 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = arrayListOf<Int>()
        val stepSize = words[0].length
        var sequencesLength = 0
        for (sequence in words) {
            sequencesLength += stepSize
        }
        if (s.length < sequencesLength) {
            return result
        }
        // 根据步长进行不同起始点的遍历
        for (startIndex in 0 until stepSize) {
            findSubstringAtIndex(startIndex, s, words, result, sequencesLength)
        }
        return result
    }

    /**
     * 从index起始，words中字符串长度为步长寻找符合结果的下标放入result中
     */
    fun findSubstringAtIndex(index: Int, s: String, words: Array<String>, result: ArrayList<Int>, sequencesLength: Int) {
        val stepSize = words[0].length
        /**
         * sequenceMap表示当前遍历的字符串和匹配子串中不同单词序列的个数
         * 遍历字符串中的单词频次为正数，匹配子串中的单词频次为负数
         * 所以当sequenceMap中所有单词的频次都为0时代表匹配成功
         * 当某个单词的频次大于1时代表遍历字符串中有多余的单词
         * 当某个单词的频次小于1时代表遍历字符串中缺少匹配子串中的单词
         */
        val sequenceMap = HashMap<String, Int>()
        //计算匹配子串单词次数
        for (sequence in words) {
            if (sequenceMap[sequence] == null) {
                sequenceMap[sequence] = -1
            } else {
                sequenceMap[sequence] = sequenceMap[sequence]!! - 1
            }
        }
        var left = index
        var right = index + sequencesLength
        if (right > s.length) {
            return
        }
        // 计算当前遍历字符串中单词出现次数
        for (i in index..(right - stepSize) step stepSize) {
            val sequence = s.substring(i, i + stepSize)
            if (sequenceMap[sequence] == null) {
                sequenceMap[sequence] = 1
            } else {
                sequenceMap[sequence] = sequenceMap[sequence]!! + 1
            }
        }
        //diff表示当前遍历序列和匹配子串的不同单词个数
        var diff = 0
        for ((key, value) in sequenceMap) {
            if (value > 0) {
                diff += value
            } else if (value < 0) {
                diff -= value
            }
        }
        if (diff == 0) {
            result.add(left)
        }
        left += stepSize
        right += stepSize
        while (right <= s.length) {
            val out = s.substring(left - stepSize, left)
            if (sequenceMap[out]!! > 0) {
                diff--
            } else if (sequenceMap[out]!! <= 0) {
                diff++
            }
            sequenceMap[out] = sequenceMap[out]!! - 1

            val newIn = s.substring(right - stepSize, right)
            if (sequenceMap[newIn] == null || sequenceMap[newIn]!! >= 0) {
                diff++
            } else {
                diff--
            }
            if (sequenceMap[newIn] == null) {
                sequenceMap[newIn] = 1
            } else {
                sequenceMap[newIn] = sequenceMap[newIn]!! + 1
            }

            if (diff == 0) {
                result.add(left)
            }

            left += stepSize
            right += stepSize
        }
    }
}