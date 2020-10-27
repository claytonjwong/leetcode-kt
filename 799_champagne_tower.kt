/*
 * 799. Champagne Tower
 *
 * Q: https://leetcode.com/problems/champagne-tower/
 * A: https://leetcode.com/problems/champagne-tower/discuss/118694/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// bottom-up
class Solution {
    fun champagneTower(K: Int, M: Int, N: Int): Double {
        var dp = Array(M + 1){ Array(N + 2){ 0.0 } }
        dp[0][0] = K.toDouble()
        for (i in 0..M - 1) {
            for (j in 0..N) {
                if (dp[i][j] <= 1.0)  // no overflow
                    continue
                var half = (dp[i][j] - 1.0) / 2  // -1.0 to fill cup i,j
                dp[i + 1][j]     += half
                dp[i + 1][j + 1] += half
            }
        }
        return Math.min(dp[M][N], 1.0)
    }
}

// memory optimized
class Solution {
    fun champagneTower(K: Int, M: Int, N: Int): Double {
        var pre = Array(N + 2) { 0.0 }
        pre[0] = K.toDouble()
        for (i in 0..M - 1) {
            var cur = Array(N + 2) { 0.0 }
            for (j in 0..N) {
                if (pre[j] <= 1.0)  // no overflow
                    continue
                var half = (pre[j] - 1.0) / 2  // -1.0 to fill cup i,j
                cur[j]     += half
                cur[j + 1] += half
            }
            pre = cur.also { cur = pre }
        }
        return Math.min(pre[N], 1.0)
    }
}
