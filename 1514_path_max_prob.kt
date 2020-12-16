/*
 * 1514. Path with Maximum Probability
 *
 * Q: https://leetcode.com/problems/path-with-maximum-probability/
 * A: https://leetcode.com/problems/path-with-maximum-probability/discuss/740901/Kt-Js-Py3-Cpp-Bellman-Ford-%2B-SPFA
 */

// BF
class Solution {
    fun maxProbability(N: Int, E: Array<IntArray>, A: DoubleArray, s: Int, t: Int): Double {
        var dist = DoubleArray(N) { 0.0 }
        dist[s] = 1.0
        for (i in 0 until N - 1) { // ⭐️ relax edges N - 1 times
            E.forEachIndexed { i, (u, v) ->
                var w = A[i]
                if (dist[v] < dist[u] * w) dist[v] = dist[u] * w
                if (dist[u] < dist[v] * w) dist[u] = dist[v] * w
            }
        }
        return dist[t]
    }
}

// SPFA
class Solution {
    fun maxProbability(N: Int, E: Array<IntArray>, A: DoubleArray, s: Int, t: Int): Double {
        var dist = DoubleArray(N) { 0.0 }
        dist[s] = 1.0
        var adj = Array(N) { mutableListOf<Pair<Int, Double>>() }
        E.forEachIndexed { i, (u, v) ->
            var w = A[i]
            adj[u].add(v to w)
            adj[v].add(u to w)
        }
        var q: Queue<Int> = LinkedList<Int>(mutableListOf<Int>(s))
        while (0 < q.size) {
            var u = q.poll()
            adj[u].forEach { (v, w) ->
                if (dist[v] < dist[u] * w) {
                    dist[v] = dist[u] * w; q.add(v) // ⭐️ cherry pick v for subsequent edges under consideration to be relaxed
                }
            }
        }
        return dist[t]
    }
}
