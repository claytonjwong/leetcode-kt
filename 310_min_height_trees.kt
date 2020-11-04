/*
 * 310. Minimum Height Trees
 *
 * Q: https://leetcode.com/problems/minimum-height-trees/
 * A: https://leetcode.com/problems/minimum-height-trees/discuss/118585/Kt-Js-Py3-Cpp-BFS-Prune-Leaves
 */

class Solution {
    fun findMinHeightTrees(N: Int, E: Array<IntArray>): List<Int> {
        if (E.size == 0)
            return listOf<Int>(0)
        var adj = mutableMapOf<Int, MutableSet<Int>>()
        for (v in 0 until N)
            adj[v] = mutableSetOf<Int>()
        E.forEach { (u, v) ->
            adj[u]!!.add(v)
            adj[v]!!.add(u)
        }
        var q: Queue<Int> = LinkedList<Int>()
        var isLeaf = { v: Int -> adj[v]!!.size == 1 }
        for (v in 0 until N)
            if (isLeaf(v))
                q.add(v)
        var cand = N
        while (2 < cand) {
            var k = q.size; cand -= k
            while (0 < k--) {
                var u = q.poll()
                adj[u]!!.forEach { v ->
                    adj[v]!!.remove(u)
                    if (isLeaf(v))
                        q.add(v)
                }
            }
        }
        return q.toList()
    }
}
