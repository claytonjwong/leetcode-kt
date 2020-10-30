/*
 * 673. Number of Longest Increasing Subsequence
 *
 * Q: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * A: https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/916696/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

class Solution {
    fun findNumberOfLIS(A: IntArray): Int {
        var length = 0
        var best = 0
        var N = A.size
        var dp = IntArray(N) { 1 }
        var cnt = IntArray(N) { 1 }
        for (j in 0 until N) {
            for (i in 0 until j) {
                if (A[i] < A[j]) {
                    if (dp[j] < 1 + dp[i]) {
                        dp[j] = 1 + dp[i]
                        cnt[j] = 0
                    }
                    if (dp[j] == 1 + dp[i])
                        cnt[j] += cnt[i]
                }
            }
            if (length < dp[j]) {
                length = dp[j]
                best = 0
            }
            if (length == dp[j])
                best += cnt[j]
        }
        return best
    }
}
