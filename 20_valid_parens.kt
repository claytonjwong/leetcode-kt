/*
 * 20. Valid Parentheses
 *
 * Q: https://leetcode.com/problems/valid-parentheses/
 * A: https://leetcode.com/problems/valid-parentheses/discuss/9214/Kt-Js-Py3-Cpp-Stack
 */

class Solution {
    fun isValid(A: String): Boolean {
        var s = Stack<Char>()
        for (c in A)
            if      (c == '(') s.push(')')
            else if (c == '[') s.push(']')
            else if (c == '{') s.push('}')
            else if (s.empty() || c != s.pop())
                return false
        return s.empty()
    }
}
