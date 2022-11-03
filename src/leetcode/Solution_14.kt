package leetcode

fun main() {
    val strs = arrayOf("ab", "a")
    print(Solution_14().longestCommonPrefixV2(strs))
}

class Solution_14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        var sameChar = ' '
        var curIndex = 0
        while (true) {
            for (index in strs.indices) {
                var curChar = getChar(strs[index], curIndex)
                if (curChar == ' ') {
                    if (index != 0) {
                        result = result.substring(0, result.length - 1)
                    }
                    return result
                }
                if (index == 0) {
                    result += curChar
                    sameChar = curChar
                    continue
                } else {
                    if (curChar != sameChar) {
                        result = result.substring(0, result.length - 1)
                        return result
                    }
                }
            }
            curIndex++
        }
        return result
    }

    fun getChar(str: String, index: Int): Char {
        if (index >= str.length) {
            return ' '
        }
        return str[index]
    }

    fun longestCommonPrefixV2(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        var firstStr = strs[0]
        var endIndex = firstStr.length - 1
        for (index in strs.indices) {
            var tempStr = strs[index]
            for (charIndex in 0..endIndex)
                if (charIndex >= tempStr.length || tempStr[charIndex] != firstStr[charIndex]) {
                    endIndex = charIndex - 1
                    break
                }
        }
        return firstStr.substring(0, endIndex + 1)
    }
}