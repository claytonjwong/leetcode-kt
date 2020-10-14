/*
 * 213. House Robber II
 *
 * Q: https://leetcode.com/problems/house-robber-ii/
 * A: https://leetcode.com/problems/house-robber-ii/discuss/894504/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// brute-force
class Solution {
    fun rob(A: IntArray): Int {
        var N = A.size
        fun go(i: Int, first: Boolean, last: Int): Int {
            if (i == N)                                                       // 🛑 base case
                return 0
            if (last + 1 == i || (first && i + 1 == N && 1 < N))              // 🚫 without i-th house (due to adjacent neighbor constraint)
                return go(i + 1, first, last)
            return maxOf(A[i] + go(i + 1, first, i), go(i + 1, first, last))  // ✅ with i-th house xor 🚫 without i-th house
        }
        return maxOf(go(0, true, -123), go(1, false, -123))                   // ✅ with first house xor 🚫 without first house
    }
}

// top-down memo
class Solution {
    fun rob(A: IntArray): Int {
        var m = mutableMapOf<String, Int>()
        var N = A.size
        fun go(i: Int, first: Boolean, last: Int): Int {
            var key = "$i,$first,$last"
            if (m.contains(key))                                                       // 🤔 memo
                return m.get(key)!!
            if (i == N)                                                                // 🛑 base case
                m.set(key, 0)
            else if (last + 1 == i || (first && i + 1 == N && 1 < N))                  // 🚫 without i-th house (due to adjacent neighbor constraint)
                m.set(key, go(i + 1, first, last))
            else
                m.set(key, maxOf(A[i] + go(i + 1, first, i), go(i + 1, first, last)))  // ✅ with i-th house xor 🚫 without i-th house
            return m.get(key)!!
        }
        return maxOf(go(0, true, -123), go(1, false, -123))                            // ✅ with first house xor 🚫 without first house
    }
}

// bottom-up
class Solution {
    fun rob(A: IntArray): Int {
        var N = A.size
        if (N == 1)                                         // 💎 corner case
            return A[0]
        fun best(start: Int): Int {
            var dp = IntArray(N + 2) { _ -> 0 }             // 🤔 memo + 🛑 base cases (ie. dp[N] = 0 and dp[N + 1] = 0)
            var begin = N - 1
            if (start == 0)
                --begin
            for (i in begin downTo 0)
                dp[i] = maxOf(A[i] + dp[i + 2], dp[i + 1])  // ✅ with i-th house xor 🚫 without i-th house
            return dp[start]
        }
        return maxOf(best(0), best(1))                      //  ✅ with first house xor 🚫 without first house
    }
}
