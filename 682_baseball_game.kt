/*
 * 682. Baseball Game
 *
 * Q: https://leetcode.com/problems/baseball-game/
 * A: https://leetcode.com/problems/baseball-game/discuss/107929/Kt-Js-Py3-Cpp-Stack-Accumulation
 */

class Solution {
    fun calPoints(ops: Array<String>): Int {
        var s = Stack<Int>()
        ops.forEach { op ->
            when (op) {
                "+"  -> s.push(s[s.lastIndex] + s[s.lastIndex - 1])
                "D"  -> s.push(2 * s.last())
                "C"  -> s.pop()
                else -> s.push(op.toInt())
            }
        }
        return s.sum()
    }
}
