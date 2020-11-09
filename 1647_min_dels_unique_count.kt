/*
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 *
 * Q: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 * A: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/discuss/927497/Kt-Js-Py3-Cpp-Map-%2B-Seen-Counts
 */

class Solution {
    fun minDeletions(s: String): Int {
        var dels = 0
        var m = mutableMapOf<Char, Int>()
        var seen = mutableSetOf<Int>()
        s.forEach{ c -> m[c] = if (m.contains(c)) m[c]!! + 1 else 1 }
        m.forEach{ (_, cnt) ->
            for (i in cnt downTo 1) {
                if (seen.contains(i)) {
                    ++dels
                } else {
                    seen.add(i)
                    break
                }
            }
        }
        return dels
    }
}
