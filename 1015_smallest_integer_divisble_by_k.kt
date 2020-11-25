/*
 * 1015. Smallest Integer Divisible by K
 *
 * Q: https://leetcode.com/problems/smallest-integer-divisible-by-k/
 * A: https://leetcode.com/problems/smallest-integer-divisible-by-k/discuss/261255/Kt-Js-Py3-Cpp-Mod-K
 */

class Solution {
    fun smallestRepunitDivByK(K: Int): Int {
        var i = 1
        var N = 1
        var mod = 0
        var seen = mutableSetOf<Int>()
        while (true) {
            mod = N % K
            if (mod == 0)
                return i
            if (seen.contains(mod))
                break
            seen.add(mod)
            N = (10 * N + 1) % K
            ++i
        }
        return -1
    }
}
