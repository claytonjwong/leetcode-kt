/*
 * 1658. Minimum Operations to Reduce X to Zero
 *
 * Q: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 * A: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/1016764/Kt-Js-Py3-Cpp-Sliding-Window
 */

class Solution {
    fun minOperations(A: IntArray, K: Int): Int {
        var best = 0
        var T = A.sum() - K
        var N = A.size
        if (T == 0)                            // 💎 corner case: if sum(A) == K, then minimum is N
            return N
        var i = 0
        var j = 0
        var t = 0
        while (j < N) {
            while (i < j && T < t + A[j])      // ⭐️ maintain invariant: sliding window total t does NOT exceed target T
                t -= A[i++]
            t += A[j++]
            if (t == T)
                best = Math.max(best, j - i)   // 💰 best "middle" subarray length [i..j), ie. from i inclusive to j non-inclusive
        }
        return if (0 < best) N - best else -1  // 🎯 minimum "left/right" subarray length == N - best
    }
}
