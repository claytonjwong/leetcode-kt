/*
 * 1446. Consecutive Characters
 *
 * Q: https://leetcode.com/problems/consecutive-characters/
 * A: https://leetcode.com/problems/consecutive-characters/discuss/639815/Kt-Js-Py3-Cpp-Best-Same
 */

// last
class Solution {
    fun maxPower(s: String): Int {
        var last = '0'
        var same = 1
        var best = 1
        s.forEach { c ->
            if (last == c) {
                best = Math.max(best, ++same)
            } else {
                last = c
                same = 1
            }
        }
        return best
    }
}

// index
class Solution {
    fun maxPower(s: String): Int {
        var same = 1
        var best = 1
        s.forEachIndexed { i, _ ->
            if (0 < i && s[i - 1] == s[i])
                best = Math.max(best, ++same)
            else
                same = 1
        }
        return best
    }
}
