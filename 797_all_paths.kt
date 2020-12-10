/*
 * 797. All Paths From Source to Target
 *
 * Q: https://leetcode.com/problems/all-paths-from-source-to-target/
 * A: https://leetcode.com/problems/all-paths-from-source-to-target/discuss/752917/Kt-Js-Py3-Cpp-DFS-%2B-BT
 */

class Solution {
    fun allPathsSourceTarget(A: Array<IntArray>): List<List<Int>> {
        var paths = mutableListOf<List<Int>>()
        var N = A.size
        var s = 0
        var t = N - 1
        fun go(path: MutableList<Int>) {
            var u = path.last()
            if (u == t)
                paths.add(path.toList())  // 🎯 target t reached
            else
                A[u].forEach { v ->
                    path.add(v)           // ✅ 👀 forward-tracking
                    go(path)              // 🚀 explore edge u -> v
                    path.remove(v)        // 🚫 👀 back-tracking
                }
        }
        go(mutableListOf<Int>(s))
        return paths
    }
}
