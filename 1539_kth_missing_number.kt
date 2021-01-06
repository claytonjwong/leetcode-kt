/*
 * 1539. Kth Missing Positive Number
 *
 * Q: https://leetcode.com/problems/kth-missing-positive-number/
 * A: https://leetcode.com/problems/kth-missing-positive-number/discuss/780016/Kt-Js-Py3-Cpp-Seen-Set-%2B-Concise
 */

// seen
class Solution {
    fun findKthPositive(A: IntArray, K: Int): Int {
        var i = 0
        var k = K
        var seen = A.toMutableSet()
        while (true)
            if (!seen.contains(++i) && --k == 0)
                return i
        return -1
    }
}

// concise
class Solution {
    fun findKthPositive(A: IntArray, K: Int): Int {
        var i = 0
        var x = 0
        var k = K
        while (0 < k && i < A.size) {
            if (++x == A[i])
                ++i
            else
                --k
        }
        return x + k
    }
}
