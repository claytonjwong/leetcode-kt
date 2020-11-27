/*
 * 416. Partition Equal Subset Sum
 *
 * Q: https://leetcode.com/problems/partition-equal-subset-sum/
 * A: https://leetcode.com/problems/partition-equal-subset-sum/discuss/617275/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// top-down
class Solution {
    fun canPartition(A: IntArray): Boolean {
        var total = A.sum()
        if (total % 2 == 1)                             // ❌ odd total cannot be evenly divided by 2
            return false
        var target = total / 2
        fun go(i: Int = 0, t: Int = 0): Boolean {
            if (i == A.size || target < t)              // 🛑 base case: target not reached
                return false
            if (t == target)                            // 🎯 target reached
                return true
            return go(i + 1, t + A[i]) || go(i + 1, t)  // ✅ with xor 🚫 without A[i]
        }
        return go()
    }
}

// memo
class Solution {
    fun canPartition(A: IntArray): Boolean {
        var m = mutableMapOf<String, Boolean>()
        var total = A.sum()
        if (total % 2 == 1)                                   // ❌ odd total cannot be evenly divided by 2
            return false
        var target = total / 2
        fun go(i: Int = 0, t: Int = 0): Boolean {
            var key = "$i,$t"
            if (m.contains(key))                              // 🤔 memo
                return m[key]!!
            if (i == A.size || target < t)                    // 🛑 base case: target not reached
                m[key] = false
            if (t == target)                                  // 🎯 target reached
                m[key] = true
            if (!m.contains(key))
                m[key] = go(i + 1, t + A[i]) || go(i + 1, t)  // ✅ with xor 🚫 without A[i]
            return m[key]!!
        }
        return go()
    }
}

// bottom-up
class Solution {
    fun canPartition(A: IntArray): Boolean {
        var total = A.sum()
        if (total % 2 == 1)                  // ❌ odd total cannot be evenly divided by 2
            return false
        var target = total / 2
        var dp = IntArray(target + 1) { 0 }  // 🤔 memo
        dp[0] = 1                            // 🛑 base case: we can reach target 0
        A.forEach{ x ->                      // 🤔 if we can reach t 🚫 without x, then we can reach t ✅ with x
            for (t in target downTo x)
                if (dp[t - x] == 1)
                    dp[t] = 1
        }
        return dp[target] == 1               // 🎯 target reached?
    }
}
