/*
 * 47. Permutations II
 *
 * Q: https://leetcode.com/problems/permutations-ii/
 * A: https://leetcode.com/problems/permutations-ii/discuss/136432/Kt-Js-Py3-Cpp-DFS-%2B-BT
 */

class Solution {
    fun permuteUnique(A: IntArray): List<List<Int>> {
        var N = A.size
        var ans = mutableListOf<List<Int>>()
        var path = mutableListOf<Int>()
        var seen = mutableSetOf<Int>()
        var unique = mutableSetOf<List<Int>>()
        fun go() {
            if (path.size == N) {
                if (!unique.contains(path)) {
                    unique.add(path)
                    ans.add(path.toList())
                }
                return
            }
            for (i in 0 until N) {
                if (!seen.contains(i)) {
                    seen.add(i)
                    path.add(A[i])
                    go()
                    path.removeAt(path.lastIndex)
                    seen.remove(i)
                }
            }
        }
        go()
        return ans
    }
}
