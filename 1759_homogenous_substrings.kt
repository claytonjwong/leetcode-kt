/*
 * 1759. Count Number of Homogenous Substrings
 *
 * Q: https://leetcode.com/problems/count-number-of-homogenous-substrings/
 * A: https://leetcode.com/problems/count-number-of-homogenous-substrings/discuss/1064522/Kt-Js-Py3-Cpp-Dynamic-Progamming
 */

// verbose
class Solution {
    fun countHomogenous(s: String): Int {
        var mod = (1e9 + 7).toInt()
        var N = s.length
        var ans = 0
        var dp = IntArray(N) { 1 }
        for (i in 0..N - 1) {
            if (0 < i && s[i - 1] == s[i])
                dp[i] = (dp[i] + dp[i - 1]) % mod
            ans = (ans + dp[i]) % mod
        }
        return ans
    }
}

// concise
class Solution {
    fun countHomogenous(s: String): Int {
        var ans = 0
        var mod = (1e9 + 7).toInt()
        var pre = 1
        var cur = 1
        var last = '0'
        for (c in s) {
            cur = if (c == last) 1 + pre else 1
            ans = (ans + cur) % mod
            pre = cur; last = c
        }
        return ans
    }
}
