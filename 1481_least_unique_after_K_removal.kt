/*
 * 1481. Least Number of Unique Integers after K Removals
 *
 * Q: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * A: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/discuss/686410/Kt-Js-Py3-Cpp-Greedy-Drop-K-Least-Frequent-via-Map
 */

class Solution {
    fun findLeastNumOfUniqueInts(A: IntArray, K: Int): Int {
        var m = mutableMapOf<Int, Int>()
        A.forEach { x -> m[x] = if (m.contains(x)) m[x]!! + 1 else 1 }
        return A.sortedWith(Comparator{ a: Int, b: Int -> if (m[a] == m[b]) a - b else m[a]!! - m[b]!! })
                .slice(K..A.lastIndex).distinct().size
    }
}
