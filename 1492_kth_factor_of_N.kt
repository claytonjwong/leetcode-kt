/*
 * 1492. The kth Factor of n
 *
 * Q: https://leetcode.com/problems/the-kth-factor-of-n/
 * A: https://leetcode.com/problems/the-kth-factor-of-n/discuss/708074/Kt-Js-Py3-Cpp-solution
 */

class Solution {
    fun kthFactor(N: Int, K: Int): Int {
        var found = 0
        for (i in 1..N)
            if (N % i == 0 && ++found == K)
                return i
        return -1
    }
}
