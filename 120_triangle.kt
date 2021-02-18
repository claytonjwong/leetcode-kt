/*
 * 120. Triangle
 *
 * Q: https://leetcode.com/problems/triangle/
 * A: https://leetcode.com/problems/triangle/discuss/38726/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

class Solution {
    fun minimumTotal(A: List<List<Int>>): Int {
        var N = A.size
        fun go(i: Int = 0, j: Int = 0): Int {
            if (i == N)
                return 0
            return A[i][j] + Math.min(go(i + 1, j), go(i + 1, j + 1))
        }
        return go()
    }
}

class Solution {
    fun minimumTotal(A: List<List<Int>>): Int {
        var m = mutableMapOf<String, Int>()
        var N = A.size
        fun go(i: Int = 0, j: Int = 0): Int {
            var key = "$i,$j";
            if (m.contains(key))
                return m[key]!!
            if (i == N)
                m[key] = 0
            else
                m[key] = A[i][j] + Math.min(go(i + 1, j), go(i + 1, j + 1))
            return m[key]!!
        }
        return go()
    }
}

class Solution {
    fun minimumTotal(A: List<List<Int>>): Int {
        var N = A.size
        var dp = ArrayList<MutableList<Int>>(N)
        for (i in 0 until N)
            dp.add(A[i].toCollection(mutableListOf()))
        for (i in N - 2 downTo 0)
            for (j in 0 until A[i].size)
                dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1])
        return dp[0][0]
    }
}
