/*
 * 948. Bag of Tokens
 *
 * Q: https://leetcode.com/problems/bag-of-tokens/
 * A: https://leetcode.com/problems/bag-of-tokens/discuss/909784/Kt-Js-Py3-Cpp-Greedy-Max-Score
 */

class Solution {
    fun bagOfTokensScore(A: IntArray, power: Int): Int {
        var score = 0
        var best = 0
        A.sort()
        var N = A.size
        var K = power
        var i = 0
        var j = N - 1
        while (i <= j && (A[i] <= K || 0 < score)) {
            if (A[i] <= K) {
                K -= A[i++]; ++score
            }
            else if (0 < score) {
                K += A[j--]; --score
            }
            best = Math.max(best, score)
        }
        return best
    }
}
