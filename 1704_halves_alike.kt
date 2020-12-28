/*
 * 1704. Determine if String Halves Are Alike
 *
 * Q: https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * A: https://leetcode.com/problems/determine-if-string-halves-are-alike/discuss/988139/kt-js-py3-cpp-halves-equal-vowel-count
 */

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        var vowels = setOf<Char>('a', 'e', 'i', 'o', 'u')
        var N = s.length
        var K = N / 2
        var a = s.substring(0..K-1)
        var b = s.substring(K..N-1)
        var isVowel = { c: Char -> vowels.contains(c.toLowerCase()) }
        return a.filter{ isVowel(it) }.length == b.filter{ isVowel(it) }.length
    }
}
