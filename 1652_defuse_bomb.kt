/*
 * 1652. Defuse the Bomb
 *
 * Q: https://leetcode.com/problems/defuse-the-bomb/
 * A: https://leetcode.com/problems/defuse-the-bomb/discuss/935371/Kt-Js-Py3-Cpp-One-Step-at-a-Time
 */

class Solution {
    fun decrypt(A: IntArray, K: Int): IntArray {
        var N = A.size
        if (K == 0)
            return IntArray(N) { 0 }
        if (K < 0)
            return decrypt(A.reversed().toIntArray(), -K).reversed().toIntArray()
        var ans = mutableListOf<Int>()
        var step = { i: Int -> if (i + 1 < N) i + 1 else 0 }
        for (i in 0 until N) {
            var total = 0
            var j = step(i)
            for (steps in 0 until K) {
                total += A[j]
                j = step(j)
            }
            ans.add(total)
        }
        return ans.toIntArray()
    }
}
