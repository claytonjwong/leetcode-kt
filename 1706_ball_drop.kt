/*
 * 1706. Where Will the Ball Fall
 *
 * Q: https://leetcode.com/problems/where-will-the-ball-fall/
 * A: https://leetcode.com/problems/where-will-the-ball-fall/discuss/988174/kt-js-py3-cpp-simulation-recursive-iterative
 */

// Recursive Concise
class Solution {
    fun findBall(A: Array<IntArray>): IntArray {
        var M = A.size
        var N = A[0].size
        fun drop(i: Int, j: Int): Int {
            return if (i == M) j else if (j in 0..N - 1 && j + A[i][j] in 0..N - 1 && A[i][j] == A[i][j + A[i][j]]) drop(i + 1, j + A[i][j]) else -1
        }
        return IntArray(N) { drop(0, it) }
    }
}

// Recursive Verbose
class Solution {
    fun findBall(A: Array<IntArray>): IntArray {
        var M = A.size
        var N = A[0].size
        fun drop(i: Int, j: Int): Int {
            if (i == M)
                return j
            if (j in 0..N - 1 && j + A[i][j] in 0..N - 1 && A[i][j] == A[i][j + A[i][j]])
                return drop(i + 1, j + A[i][j])
            return -1
        }
        return IntArray(N) { j -> drop(0, j) }
    }
}

// Iterative
class Solution {
    fun findBall(A: Array<IntArray>): IntArray {
        var ans = mutableListOf<Int>()
        var M = A.size
        var N = A[0].size
        for (k in 0..N - 1) {
            var i = 0
            var j = k
            while (i < M && j in 0..N - 1 && j + A[i][j] in 0..N - 1 && A[i][j] == A[i][j + A[i][j]]) {
                j += A[i][j]; ++i
            }
            ans.add(if (i == M) j else -1)
        }
        return ans.toIntArray()
    }
}
