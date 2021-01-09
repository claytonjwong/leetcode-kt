/*
 * 1716. Calculate Money in Leetcode Bank
 *
 * Q: https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 * A: https://leetcode.com/problems/calculate-money-in-leetcode-bank/discuss/1008853/Kt-Js-Py3-Cpp-Iterative-Accumulation
 */

class Solution {
    fun totalMoney(n: Int): Int {
        var total = 0
        var start = 1
        var x = 0
        for (day in 0 until n) {
            if (day % 7 == 0)
                x = start++
            total += x++
        }
        return total
    }
}
