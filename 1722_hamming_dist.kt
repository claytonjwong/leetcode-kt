/*
 * 1722. Minimize Hamming Distance After Swap Operations
 *
 * Q: https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 * A: https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/discuss/1009782/Kt-Js-Py3-Cpp-Union-Find-%2B-Set-Diff
 */

class Solution {
    fun minimumHammingDistance(s: IntArray, t: IntArray, A: Array<IntArray>): Int {
        var N = s.size
        var P = IntArray(N) { it }  // 🔗  N disjoint parent representatives of unioned indices
        fun find(x: Int): Int {
            P[x] = if (x == P[x]) x else find(P[x])
            return P[x]
        }
        fun union(a: Int, b: Int) {
            var c = find(a)
            var d = find(b)
            P[c] = d  // 🎲 arbitrary choice
        }
        A.forEach { (i, j) -> union(i, j) }
        var ms = mutableMapOf<Int, MutableList<Int>>()
        var mt = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until N) {
            var x = find(P[i])
            if (!ms.contains(x)) ms[x] = mutableListOf<Int>()
            if (!mt.contains(x)) mt[x] = mutableListOf<Int>()
            ms[x]!!.add(s[i])
            mt[x]!!.add(t[i])
        }
        fun diff(x: Int): Int {
            var pairs = 0
            var m = mutableMapOf<Int, Int>()
            ms[x]!!.forEach { value -> m[value] =  1 + m.getOrDefault(value, 0) }
            mt[x]!!.forEach { value -> m[value] = -1 + m.getOrDefault(value, 0) }
            m!!.values.forEach{ cnt -> pairs += Math.abs(cnt).toInt() }
            return pairs / 2
        }
        return P.map{ find(it) }.toSet()!!.map{ diff(it) }!!.sum()
    }
}
