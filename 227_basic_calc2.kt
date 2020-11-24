/*
 * 227. Basic Calculator II
 *
 * Q: https://leetcode.com/problems/basic-calculator-ii/
 * A: https://leetcode.com/problems/basic-calculator-ii/discuss/947645/Kt-Js-Py3-Cpp-Stack
 */

class Solution {
    fun calculate(expr: String): Int {
        var S = mutableListOf<Int>()
        var x = 0
        var op = '+'
        var N = expr.length
        for (i in 0..N) {
            if (i < N && expr[i] == ' ')
                continue
            if (i < N && expr[i].isDigit()) {
                x = 10 * x + (expr[i] - '0')
                continue
            }
            if (op == '+') S.add(x)
            if (op == '-') S.add(-x)
            if (op == '*') S[S.lastIndex] *= x
            if (op == '/') S[S.lastIndex] /= x
            x = 0; op = if (i < N) expr[i] else '?'
        }
        return S.sum()
    }
}
