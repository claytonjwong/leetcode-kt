/*
 * 88. Merge Sorted Array
 *
 * Q: https://leetcode.com/problems/merge-sorted-array/
 * A: https://leetcode.com/problems/merge-sorted-array/discuss/670661/Kt-Js-Py3-Cpp-Merge-from-Right-to-Left
 */

class Solution {
    fun merge(A: IntArray, M: Int, B: IntArray, N: Int): Unit {
        var i = M - 1
        var j = N - 1
        var k = M + N - 1
        while (0 <= j)
            A[k--] = if (i < 0 || A[i] < B[j]) B[j--] else A[i--]
    }
}
