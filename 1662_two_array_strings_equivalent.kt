/*
 * 1662. Check If Two String Arrays are Equivalent
 *
 * Q: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 * A: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/discuss/948963/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun arrayStringsAreEqual(A: Array<String>, B: Array<String>): Boolean {
        return A.joinToString("", "", "") == B.joinToString("", "", "")
    }
}
