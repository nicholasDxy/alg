package leetcode

fun main() {
    print(Solution_50().myPow(2.0000, 10))
}

class Solution_50 {

    fun myPow(x: Double, n: Int): Double {
        val flag = n > 0
        val positiveResult = doPower(x, n)
        return if (flag) positiveResult else 1 / positiveResult
    }

    private fun doPower(x: Double, n: Int): Double {
        if (n == 0) {
            return 1.0
        }
        val halfX = doPower(x, n / 2)
        return if (n % 2 == 0) halfX * halfX else halfX * halfX * x
    }

}