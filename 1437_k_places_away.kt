/*
 * 1437. Check If All 1's Are at Least Length K Places Away
 *
 * Q: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 * A: https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/discuss/613577/Kt-Js-Py3-Cpp-Last-Seen-Index
 */

class Solution {
    fun kLengthApart(A: IntArray, K: Int): Boolean {
        var last = -1e5.toInt()
        for (i in 0 until A.size) {
            if (A[i] == 0)
                continue
            var ok = K < i - last; last = i
            if (!ok)
                return false
        }
        return true
    }
}
