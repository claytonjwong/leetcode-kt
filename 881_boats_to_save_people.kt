/*
 * 881. Boats to Save People
 *
 * Q: https://leetcode.com/problems/boats-to-save-people/
 * A: https://leetcode.com/problems/boats-to-save-people/discuss/1014992/Kt-Js-Py3-Cpp-Greedily-Consume-Boats
 */

// concise
class Solution {
    fun numRescueBoats(A: IntArray, K: Int): Int {
        var cnt = 0
        A.sort()
        var N = A.size
        var i = 0
        var j = N - 1
        while (i <= j) {
            if (A[i] + A[j] <= K)
                ++i                // 🙂 i-th person sometimes fits in the boat ⛵️
            ++cnt; --j             // 🙂 j-th person always    fits in the boat ⛵️
        }
        return cnt                 // 🎯 minimum boat count via 💰 greedy consumption
    }
}

// verbose
class Solution {
    fun numRescueBoats(A: IntArray, K: Int): Int {
        var cnt = 0
        A.sort()
        var N = A.size
        var i = 0
        var j = N - 1
        while (i <= j) {
            if (A[i] + A[j] <= K) {            // ⛵️ case 1: both 🙂 i-th and 🙂 j-th person
                ++cnt; ++i; --j
            } else {                           // ⛵️ case 2: only 😕 j-th person
                ++cnt; --j
            }
        }
        return cnt                             // 🎯 minimum boat count via 💰 greedy consumption
    }
}
