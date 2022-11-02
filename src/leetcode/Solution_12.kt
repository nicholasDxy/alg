package leetcode


fun main() {
    println(Solution_12().intToRomanV2(20))
}


class Solution_12 {

    private val map = mapOf<Int, String>(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
    )


    fun intToRoman(num: Int): String {
        var tempNum = num
        var roman = ""
        while (tempNum > 0) {
            for ((key, value) in map) {
                if (key <= tempNum) {
                    roman += value
                    tempNum -= key
                    break
                }
            }
        }
        return roman
    }

    fun intToRomanV2(num: Int): String {
        var tempNum = num
        var roman = ""
        for ((key, value) in map) {
            if (key <= tempNum) {
                var times: Int = tempNum / key
                tempNum -= key * times
                while (times > 0) {
                    roman += value
                    times--
                }
            }
        }
        return roman
    }

}