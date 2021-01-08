/*
 * 1708. Largest Subarray Length K
 *
 * Q: https://leetcode.com/problems/largest-subarray-length-k/
 * A: https://leetcode.com/problems/largest-subarray-length-k/discuss/1007617/Kt-Js-Py3-Cpp-Sliding-Window
 */

class Solution {
    fun largestSubarray(A: IntArray, K: Int): IntArray {
        var cand = A.slice(0..K - 1).toMutableList()
        var best = cand.toIntArray()
        for (i in K until A.size) {
            cand.removeAt(0); cand.add(A[i])
            var better = false
            for (j in 0 until K) {
                if (best[j] != cand[j]) {
                    better = best[j] < cand[j]
                    break
                }
            }
            if (better)
                best = cand.toIntArray()
        }
        return best
    }
}
