/*
 * 78. Subsets
 *
 * Q: https://leetcode.com/problems/subsets/
 * A: https://leetcode.com/problems/subsets/discuss/731155/Kt-Js-Py3-Cpp-DFS-%2B-BT
 */

class Solution {
    fun subsets(A: IntArray): List<List<Int>> {
        var paths = mutableListOf<List<Int>>()
        var N = A.size
        fun go(i: Int = 0, path: MutableList<Int> = mutableListOf<Int>()) {
            if (i == N) {
                paths.add(path.toList())  // 🛑 base case: add the unique path onto the answer
                return
            }
            path.add(A[i])
            go(i + 1, path)               // ✅ with A[i]
            path.remove(A[i])
            go(i + 1, path)               // 🚫 without A[i]
        }
        go()
        return paths.toList()
    }
}
