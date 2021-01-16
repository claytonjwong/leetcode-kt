/*
 * 215. Kth Largest Element in an Array
 *
 * Q: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * A: https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/153981/Kt-Js-Py3-Cpp-Sort
 */

class Solution {
    fun findKthLargest(A: IntArray, K: Int): Int {
        var N = A.size
        A.sort()
        return A[N - K]
    }
}
