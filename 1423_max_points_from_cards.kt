/*
 * 1423. Maximum Points You Can Obtain from Cards
 *
 * Q: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * A: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597883/Kt-Js-Py3-Cpp-Brute-Force-Sliding-Window
 */

class Solution {
    fun maxScore(A: IntArray, K: Int): Int {
        var N = A.size
        var i = 0
        var j = N - K
        var total = A.slice(j..N - 1).sum()
        var best = total
        while (j < N) {  // slide window by K 👉
            total += A[i++] - A[j++]
            best = Math.max(best, total)
        }
        return best
    }
}
