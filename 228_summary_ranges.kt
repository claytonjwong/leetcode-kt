/*
 * 228. Summary Ranges
 *
 * Q: https://leetcode.com/problems/summary-ranges/
 * A: https://leetcode.com/problems/summary-ranges/discuss/913748/Kt-Js-Py3-Cpp-Monotonic-Chains
 */

class Solution {
    fun summaryRanges(A: IntArray): List<String> {
        var chain = mutableListOf<Int>()
        var chains = mutableListOf<String>()
        fun save(): Unit {
            chains.add(if (chain.first() == chain.last()) "${chain.first()}" else "${chain.first()}->${chain.last()}")
            chain.clear()
        }
        A.forEach { x ->
            if (!chain.isEmpty() && x != 1 + chain.last())  // 🚫 broken link in the chain 🔗
                save()
            chain.add(x)
        }
        if (!chain.isEmpty())
            save()
        return chains
    }
}
