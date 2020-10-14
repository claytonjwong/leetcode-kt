/*
 * 150. Evaluate Reverse Polish Notation
 *
 * Q: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * A: https://leetcode.com/problems/evaluate-reverse-polish-notation/discuss/893409/Kt-Js-Py3-Cpp-Stack-(c-a-op-b)
 */

class Solution {
    fun evalRPN(A: Array<String>): Int {
        var S = ArrayDeque<Int>()
        A.forEach { x ->
            var num = x.toIntOrNull()
            if (num != null) {
                S.push(num)
            } else {
                var b = S.pop()
                var a = S.pop()
                var c = 0
                when(x) {
                    "+" -> c = a + b
                    "-" -> c = a - b
                    "*" -> c = a * b
                    else -> c = a / b
                }
                S.push(c)
            }
        }
        return S.pop()
    }
}
