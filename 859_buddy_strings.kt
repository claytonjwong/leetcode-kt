/*
 * 859. Buddy Strings
 *
 * Q: https://leetcode.com/problems/buddy-strings/
 * A: https://leetcode.com/problems/buddy-strings/discuss/141769/Kt-Js-Py3-C%2B%2B-solutions
 */

class Solution {
    fun buddyStrings(A: String, B: String): Boolean {
        var M = A.length
        var N = B.length
        if (M != N)
            return false
        if (A == B)
            return A.toCharArray().distinct().size < N
        var j = -1
        var k = -1
        for (i in 0 until N) {
            if (A[i] != B[i]) {
                j = k; k = i
            }
        }
        if (j == -1 || k == -1)
            return false
        var t = A.toCharArray()
        t[j] = t[k].also { t[k] = t[j] }
        return t.joinToString("") == B
    }
}

