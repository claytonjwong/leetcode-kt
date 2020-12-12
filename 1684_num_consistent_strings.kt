/*
 * 1684. Count the Number of Consistent Strings
 *
 * Q: https://leetcode.com/problems/count-the-number-of-consistent-strings/
 * A: https://leetcode.com/problems/count-the-number-of-consistent-strings/discuss/969513/Kt-Js-Py3-Cpp-1-Liners
 */

// 1-liner
class Solution {
    fun countConsistentStrings(A: String, words: Array<String>): Int {
        return words.count{ it.all{ c -> A.toSet().contains(c) } }
    }
}

// verbose
class Solution {
    fun countConsistentStrings(A: String, words: Array<String>): Int {
        var cnt = 0
        var dict = A.toSet()
        return words.count{ it.all{ c -> dict.contains(c) } }
    }
}
