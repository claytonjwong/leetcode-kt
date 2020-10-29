/*
 * 1480. Running Sum of 1d Array
 *
 * Q: https://leetcode.com/problems/running-sum-of-1d-array/
 * A: https://leetcode.com/problems/running-sum-of-1d-array/discuss/686233/Javascript-and-C%2B%2B-solutions
 */

class Solution {
    fun runningSum(A: IntArray): IntArray {
        var N = A.size
        var B = IntArray(N) { 0 }
        B[0] = A[0]
        for (i in 1 until N)
            B[i] = B[i - 1] + A[i]
        return B
    }
}
