/*
 * 1007. Minimum Domino Rotations For Equal Row
 *
 * Q: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * A: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/discuss/252219/Kt-Js-Py3-Cpp-Brute-Force
 */

class Solution {
    fun minDominoRotations(A: IntArray, B: IntArray, INF: Int = (1e9 + 7).toInt()): Int {
        var N = A.size
        fun rotate(cur: IntArray, alt: IntArray, T: Int): Int {
            var cnt = 0
            for (i in 0 until N) {
                if (cur[i] == T)
                    continue
                if (alt[i] == T)
                    ++cnt
                else
                    return INF
            }
            return cnt
        }
        var cand = intArrayOf( rotate(A, B, A[0]), rotate(A, B, B[0]),
                               rotate(B, A, A[0]), rotate(B, A, B[0]) )
        return if (cand.all { it == INF }) -1 else cand.min()!!
    }
}
