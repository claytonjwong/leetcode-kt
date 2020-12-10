/*
 * 941. Valid Mountain Array
 *
 * Q: https://leetcode.com/problems/valid-mountain-array/
 * A: https://leetcode.com/problems/valid-mountain-array/discuss/739686/Kt-Js-Py3-Cpp-Climb-Mountain-to-Find-Peak
 */

class Solution {
    fun validMountainArray(A: IntArray): Boolean {
        var N = A.size
        var i = 0
        var j = N - 1
        while (i + 1 < N  && A[i] < A[i + 1]) ++i  // 👉 climb from left-to-eight
        while (0 <= j - 1 && A[j - 1] > A[j]) --j  // 👈 climb from right-to-left
        return 0 < i && i == j && j < N - 1        // 🎯 mountain peak
    }
}
