/*
 * 1624. Largest Substring Between Two Equal Characters
 *
 * Q: https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 * A: https://leetcode.com/problems/largest-substring-between-two-equal-characters/discuss/900287/Kt-Js-Py3-Cpp-Map-(concise-%2B-verbose)-solutions
 */

// concise
class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        var m = mutableMapOf<Char, Int>()
        s.forEachIndexed { i, c -> m[c] = i }
        return s.mapIndexed{ i, c -> m[c]!! - i - 1 }.max()!!  // -1 for (i..j) non-inclusive
    }
}

// verbose
class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        var best = -1
        var m = mutableMapOf<Char, Int>()
        s.forEachIndexed { i, c ->
            if (m.contains(c))
                best = maxOf(best, i - m[c]!! - 1)  // -1 for (i..j) non-inclusive
            else
                m[c] = i
        }
        return best
    }
}
