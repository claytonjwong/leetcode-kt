/*
 * 799. Champagne Tower
 *
 * Q: https://leetcode.com/problems/champagne-tower/
 * A: https://leetcode.com/problems/champagne-tower/discuss/118694/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// top-down with memo
class Solution {
    fun champagneTower(K: Int, M: Int, N: Int): Double {
        var m = mutableMapOf<String, Double>()
        fun go(i: Int, j: Int): Double {
            var key = "$i,$j"
            if (m.contains(key))
                return m[key]!!               // 🤔 memo
            else if (i == 0 && j == 0)
                m[key] = K.toDouble()         // 🛑 base case: glass at row 0 column 0 has K poured through it
            else if (i == 0 || j < 0)
                m[key] = 0.0                  // 🚫 non-existent parent glass has 0.0 poured through it
            else {
                // ⭐️ each parent glass above-and-to-the-(L)eft/(R)ight either overflow when the amount poured exceeds 1.0 xor do *not* overflow when the amount poured does *not* exceed 1.0
                // 💎 -1.0 since parent glass above consumes at-most 1.0 of the pour and div 2 when overflow occurs, because half overflows on each side of the parent glass
                var L = go(i - 1, j - 1)
                var R = go(i - 1, j)
                m[key] = (if (1.0 <= L) (L - 1.0) / 2 else 0.0) + (if (1.0 <= R) (R - 1.0) / 2 else 0.0)
            }
            return m[key]!!
        }
        go(M, Math.max(M, N))                 // 🌟 since the glasses above-and-to-the-right potentially contribute to the amount poured to M, N we choose N to be the maximum of M, N
    return Math.min(go(M, N), 1.0);
        return Math.min(go(M, N), 1.0)
    }
}

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
