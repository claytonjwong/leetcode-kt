/*
 * 1619. Mean of Array After Removing Some Elements
 *
 * Q: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 * A: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/discuss/898684/Kt-Js-Py3-Cpp-Sort-Trim-Average
 */

class Solution {
    fun trimMean(A: IntArray): Double {
        var N = A.size
        var K = N / 20
        return A.sorted().slice(K..N - K - 1).sum() / (N - 2 * K).toDouble()
    }
}
