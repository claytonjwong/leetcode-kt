/*
 * 189. Rotate Array
 *
 * Q: https://leetcode.com/problems/rotate-array/
 * A: https://leetcode.com/problems/rotate-array/discuss/895736/Kt-Js-Py3-Cpp-K-Rotations
 */

class Solution {
    fun rotate(A: IntArray, K: Int): Unit {
        for (i in 0 until K) {
            var last = A.last()
            for (j in A.lastIndex downTo 1)
                A[j] = A[j - 1]
            A[0] = last
        }
    }
}
