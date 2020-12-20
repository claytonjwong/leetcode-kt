/*
 * 1695. Maximum Erasure Value
 *
 * Q: https://leetcode.com/problems/maximum-erasure-value/
 * A: https://leetcode.com/problems/maximum-erasure-value/discuss/978556/Kt-Js-Py3-Cpp-Sliding-Window-%2B-Seen-Set
 */

class Solution {
    fun maximumUniqueSubarray(A: IntArray): Int {
        var best = 0
        var total = 0
        var seen = mutableSetOf<Int>()
        var N = A.size
        var i = 0
        var j = 0
        while (j < N) {
            if (seen.contains(A[j])) {    // 👉 shrink window to maintain loop invariant A[i..j] 👀 uniquely seen
                total -= A[i]
                seen.remove(A[i++])
            } else {                      // 👉 expand window
                total += A[j]
                seen.add(A[j++])
            }
            best = Math.max(best, total)  // 🎯 best total A[i..j]
        }
        return best
    }
}
