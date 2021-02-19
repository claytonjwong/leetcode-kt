/*
 * 338. Counting Bits
 *
 * Q: https://leetcode.com/problems/counting-bits/
 * A: https://leetcode.com/problems/counting-bits/discuss/657068/Kt-Js-Py3-Cpp-Dynamic-Programming
 */

class Solution {
    fun countBits(N: Int): IntArray {
        var ans = mutableListOf(0)
        for (i in 1..N)
            ans.add(ans[i shr 1] + (i and 1))
        return ans.toIntArray()
    }
}
