/*
 * 1680. Concatenation of Consecutive Binary Numbers
 *
 * Q: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 * A: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/discuss/962337/Kt-Js-Py3-Cpp-Construct-and-sum-Accumulate
 */

class Solution {
    fun concatenatedBinary(N: Int): Int {
        var ans: Long = 0
        var mod: Long = (1e9 + 7).toLong()
        var k: Long = 1
        var s = mutableListOf<Char>()
        for (x in 1..N) {
            var pad = false
            for (i in 31 downTo 0) {
                if (x and (1 shl i) != 0) {
                    s.add('1')
                    pad = true
                } else if (pad) {
                    s.add('0')
                }
            }
        }
        s.reversed().forEach { c ->
            if (c == '1')
                ans = (ans + k) % mod
            k = 2 * k % mod
        }
        return ans.toInt()
    }
}
