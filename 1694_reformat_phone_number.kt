/*
 * 1694. Reformat Phone Number
 *
 * Q: https://leetcode.com/problems/reformat-phone-number/
 * A: https://leetcode.com/problems/reformat-phone-number/discuss/978502/kt-js-py3-cpp-recursive-solutions
 */

class Solution {
    fun reformatNumber(s: String): String {
        fun go(s: String): String {
            var N = s.length
            if (N <= 3) return s
            if (N == 4) return s.substring(0, 2) + "-" + s.substring(2)
            return s.substring(0, 3) + "-" + go(s.substring(3))
        }
        return go(s.filter{ c -> c != ' ' && c != '-' })
    }
}
