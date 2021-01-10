/*
 * 1720. Decode XORed Array
 *
 * Q: https://leetcode.com/problems/decode-xored-array/
 * A: https://leetcode.com/problems/decode-xored-array/discuss/1009766/Kt-Js-Py3-Cpp-XOR-Last
 */

class Solution {
    fun decode(A: IntArray, K: Int): IntArray {
        var ans = mutableListOf<Int>(K)
        A.forEach{ ans.add(it xor ans.last()) }
        return ans.toIntArray()
    }
}
