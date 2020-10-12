/*
 * 1614. Maximum Nesting Depth of the Parentheses
 *
 * Q: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * A: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/discuss/888880/Kt-Js-Py3-C%2B%2B-Count-Depth
 */

class Solution {
    fun maxDepth(s: String): Int {
        var cnt = 0
        var best = 0
        s.forEach { c ->
            if (c == '(') ++cnt; best = maxOf(best, cnt)
            if (c == ')') --cnt
        }
        return best
    }
}
