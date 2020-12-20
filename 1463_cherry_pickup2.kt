/*
 * 1463. Cherry Pickup II
 *
 * Q: https://leetcode.com/problems/cherry-pickup-ii/
 * A: https://leetcode.com/problems/cherry-pickup-ii/discuss/660828/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// top-down
class Solution {
    fun cherryPickup(A: Array<IntArray>): Int {
        var M = A.size
        var N = A[0].size
        fun go(k: Int = 0, i: Int = 0, j: Int = N - 1): Int {
            if (k == M)
                return 0
            var best = 0
            arrayOf(i - 1, i, i + 1).forEach { u ->
                arrayOf(j - 1, j, j + 1).forEach { v ->
                    if (!(u < 0 || v < 0 || u == M || v == N || v <= u))
                        best = Math.max(best, go(k + 1, u, v))
                }
            }
            return A[k][i] + A[k][j] + best
        }
        return go()
    }
}

// top-down w/ memo
class Solution {
    fun cherryPickup(A: Array<IntArray>): Int {
        var M = A.size
        var N = A[0].size
        var m = mutableMapOf<String, Int>()
        fun go(k: Int = 0, i: Int = 0, j: Int = N - 1): Int {
            var key = "$k,$i,$j"
            if (m.contains(key))
                return m[key]!!
            if (k == M) {
                m[key] = 0
                return m[key]!!
            }
            var best = 0
            arrayOf(i - 1, i, i + 1).forEach { u ->
                arrayOf(j - 1, j, j + 1).forEach { v ->
                    if (!(u < 0 || v < 0 || u == M || v == N || v <= u))
                        best = Math.max(best, go(k + 1, u, v))
                }
            }
            m[key] = A[k][i] + A[k][j] + best
            return m[key]!!
        }
        return go()
    }
}

// bottom-up
class Solution {
    fun cherryPickup(A: Array<IntArray>): Int {
        var M = A.size
        var N = A[0].size
        var dp = Array(M + 1) { Array(N) { IntArray(N) } }
        for (k in M - 1 downTo 0)
            for (i in 0 until N)
                for (j in 0 until N)
                    for (u in arrayOf(i - 1, i, i + 1))
                        for (v in arrayOf(j - 1, j, j + 1))
                            if (!(u < 0 || v < 0 || u == M || v == N || v <= u))
                                dp[k][i][j] = Math.max(dp[k][i][j], A[k][i] + A[k][j] + dp[k + 1][u][v])
        return dp[0][0][N - 1]
    }
}

// bottom-up mem-opt
class Solution {
    fun cherryPickup(A: Array<IntArray>): Int {
        var M = A.size
        var N = A[0].size
        var pre = Array(N) { IntArray(N) }
        for (k in M - 1 downTo 0) {
            var cur = Array(N) { IntArray(N) }
            for (i in 0 until N)
                for (j in 0 until N)
                    for (u in arrayOf(i - 1, i, i + 1))
                        for (v in arrayOf(j - 1, j, j + 1))
                            if (!(u < 0 || v < 0 || u == M || v == N || v <= u))
                                cur[i][j] = Math.max(cur[i][j], A[k][i] + A[k][j] + pre[u][v])
            pre = cur.also{ cur = pre }
        }
        return pre[0][N - 1]
    }
}
