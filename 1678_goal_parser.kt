/*
 * 1678. Goal Parser Interpretation
 *
 * Q: https://leetcode.com/problems/goal-parser-interpretation/
 * A: https://leetcode.com/problems/goal-parser-interpretation/discuss/962100/Kt-Js-Py3-Cpp-Linear-Scan-%2B-Last-Seen
 */

class Solution {
    fun interpret(s: String): String {
        var ans = ""
        var last = 'x'
        s.forEach { c ->
            if (c == 'G') ans += "G"
            if (c == ')') ans += if (last == '(') "o" else "al"
            last = c
        }
        return ans
    }
}
