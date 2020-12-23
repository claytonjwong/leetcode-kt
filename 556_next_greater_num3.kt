/*
 * 556. Next Greater Element III
 *
 * Q: https://leetcode.com/problems/next-greater-element-iii/
 * A: https://leetcode.com/problems/next-greater-element-iii/discuss/983450/Kt-Js-Py3-Cpp-Brute-Force-Permutations
 */

fun <T> permutations(input: List<T>): List<List<T>> {
    if (input.size == 1) return listOf(input)
    val perms = mutableListOf<List<T>>()
    val toInsert = input[0]
    for (p in permutations(input.drop(1))) {
        for (i in 0..p.size) {
            val newPerm = p.toMutableList()
            newPerm.add(i, toInsert)
            perms.add(newPerm)
        }
    }
    return perms
}
class Solution {
    fun nextGreaterElement(T: Int): Int {
        var best = (1e9 - 1).toInt()
        var A = T.toString().toList()
        for (p in permutations(A)) {
            var cand = p.joinToString("").toLong()
            if (T < cand && cand < best && cand < 1e9 - 1)
                best = cand.toInt()
        }
        return if (best < 1e9 -1) best else -1
    }
}
