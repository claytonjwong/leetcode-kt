/*
 * 849. Maximize Distance to Closest Person
 *
 * Q: https://leetcode.com/problems/maximize-distance-to-closest-person/
 * A: https://leetcode.com/problems/maximize-distance-to-closest-person/discuss/137957/Kt-Js-Py3-Cpp-Distance-from-LeftRight
 */

class Solution {
    fun maxDistToClosest(A: IntArray): Int {
        var best = 0
        var N = A.size
        var L = IntArray(N) { N }
        var R = IntArray(N) { N }
        if (A[0] == 1)
            L[0] = 0
        if (A[N - 1] == 1)
            R[N - 1] = 0
        for (i in 1 until N)
            L[i] = if (A[i] == 1) 0 else 1 + L[i - 1]  // distance from (L)eft-to-right 👉
        for (i in N - 2 downTo 0)
            R[i] = if (A[i] == 1) 0 else 1 + R[i + 1]  // distance from (R)ight-to-left 👈
        for (i in 0 until N)
            best = Math.max(best, Math.min(L[i], R[i]))
        return best
    }
}
