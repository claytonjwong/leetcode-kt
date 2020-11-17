/*
 * 1654. Minimum Jumps to Reach Home
 *
 * Q: https://leetcode.com/problems/minimum-jumps-to-reach-home/
 * A: https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/935386/Kt-Js-Py3-Cpp-BFS-%2B-DFS-solutions
 */

// BFS
class Solution {
    fun minimumJumps(A: IntArray, R: Int, L: Int, T: Int): Int {
        var forbidden = A.toSet()
        var seen = mutableSetOf<String>("0,false")
        var q = mutableListOf(Triple(0, false, 0))
        fun markSeen(i: Int, backwards: Boolean): Boolean {
            var key = "$i,$backwards"
            if (seen.contains(key))
                return false
            seen.add(key)
            return true
        }
        var ok = { i: Int, backwards: Boolean -> 0 <= i && i < 4000 && !forbidden.contains(i) && markSeen(i, backwards) }
        while (0 < q.size) {
            var (i, backwards, steps) = q[0]; q.removeAt(0)
            if (i == T)
                return steps
            if (ok(i + R, false))
                q.add(Triple(i + R, false, steps + 1))
            if (!backwards && ok(i - L, true))
                q.add(Triple(i - L, true, steps + 1))
        }
        return -1
    }
}

// DFS
class Solution {
    fun minimumJumps(A: IntArray, R: Int, L: Int, T: Int): Int {
        var INF = (1e9 + 7).toInt()
        var best = INF
        var forbidden = A.toSet()
        var seen = mutableSetOf<String>()
        fun go(i: Int = 0, steps: Int = 0, backwards: Boolean = false): Unit {
            if (forbidden.contains(i))        // 🚫 forbidden
                return
            var key = "$i,$backwards"
            if (seen.contains(key))           // 👀 seen
                return
            seen.add(key)
            if (i == T) {
                best = Math.min(best, steps)  // 🎯 minimum steps to reach target
                return
            }
            if (i < 0 || 4000 < i)            // 🛑 out of bounds
                return
            go(i + R, steps + 1, false)       // 🚀 DFS explore 👉 to-the-right
            if (!backwards)
                go(i - L, steps + 1, true)    // 🚀 DFS explore 👈 to-the-left
        }
        go()
        return if (best < INF) best else -1
    }
}
