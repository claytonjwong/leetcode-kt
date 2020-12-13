/*
 * 1688. Count of Matches in Tournament
 *
 * Q: https://leetcode.com/problems/count-of-matches-in-tournament/
 * A: https://leetcode.com/problems/count-of-matches-in-tournament/discuss/970250/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun numberOfMatches(N: Int): Int {
        return if (N == 1) 0 else N / 2 + numberOfMatches(N / 2 + (if (N % 2 == 1) 1 else 0))
    }
}
