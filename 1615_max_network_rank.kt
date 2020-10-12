/*
 * 1615. Maximal Network Rank
 *
 * Q: https://leetcode.com/problems/maximal-network-rank/
 * A: https://leetcode.com/problems/maximal-network-rank/discuss/888884/Kt-Js-Py3-Cpp-Brute-Force
 */

class Solution {
    fun maximalNetworkRank(N: Int, A: Array<IntArray>): Int {
        var best = 0
        var adj = Array(N) { mutableSetOf<Int>() }
        var degree = { v: Int -> adj[v].size }
        A.forEach { (u, v) ->
            adj[u].add(v)
            adj[v].add(u)
        }
        for (i in 0 until N)
            for (j in i + 1 until N)
                best = maxOf(best, degree(i) + degree(j) - (if (adj[i].contains(j)) 1 else 0))
        return best
    }
}
