/*
 * 266. Palindrome Permutation
 *
 * Q: https://leetcode.com/problems/palindrome-permutation/
 * A: https://leetcode.com/problems/palindrome-permutation/discuss/592736/Kt-Js-Py3-Cpp-Seen-Odd
 */

class Solution {
    fun canPermutePalindrome(s: String): Boolean {
        var seen = mutableSetOf<Char>()
        s.forEach { c -> if (seen.contains(c)) seen.remove(c) else seen.add(c) }
        return seen.size <= 1
    }
}
