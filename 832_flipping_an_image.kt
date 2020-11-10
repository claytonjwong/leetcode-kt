/*
 * 832. Flipping an Image
 *
 * Q: https://leetcode.com/problems/flipping-an-image/
 * A: https://leetcode.com/problems/flipping-an-image/discuss/131721/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        return A.map{ row -> row.reversed().map{ x -> x xor 1 }.toIntArray() }.toTypedArray()
    }
}
