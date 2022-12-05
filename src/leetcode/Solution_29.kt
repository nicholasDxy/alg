package leetcode

import kotlin.math.abs

fun main() {
    print(Solution_29().divide(-2147483648, -1))
}

class Solution_29 {
    fun divide(dividend: Int, divisor: Int): Int {
        var flag = 1
        val negDividend = if (dividend > 0) {
            flag *= -1
            -dividend
        } else {
            dividend
        }
        val negDivisor = if (divisor > 0) {
            flag *= -1
            -divisor
        } else {
            divisor
        }
        return findQuotient(negDividend, negDivisor, - 1, -negDividend) * flag
    }


    // 默认dividend；divisor都为负，quotient为正
    fun findQuotient(dividend: Int, divisor: Int, left: Int, right: Int): Int {
        if (dividend > divisor) {
            return 0
        }
        val mid = -left shr 1 - right shr 1
        val multiResult = multi(divisor, mid)
        if (multiResult == dividend || dividend < multiResult && abs(dividend - multiResult) < abs(divisor)) {
            return mid
        } else if (multiResult < dividend) {
            return findQuotient(dividend, divisor, left, mid)
        } else {
            return findQuotient(dividend, divisor, mid + 1, right)
        }
    }

    fun multi(x: Int, n: Int): Int {
        var flag = 1
        var xx = if (x > 0) {
            x
        } else {
            flag *= -1
            -x
        }
        var nn = if (n > 0) {
            n
        } else {
            flag *= -1
            -n
        }
        return noSignMulti(xx, nn) * flag
    }

    fun noSignMulti(x: Int, n: Int): Int {
        val less: Int
        val more: Int
        if (abs(x) > abs(n)) {
            less = n
            more = x
        } else {
            less = x
            more = n
        }
        if (less == 0) {
            return 0
        }
        val half = noSignMulti(more, less / 2)
        return if (less % 2 == 0) half + half else half + half + more
    }

}