/*
 * 804. Unique Morse Code Words
 *
 * Q: https://leetcode.com/problems/unique-morse-code-words/
 * A: https://leetcode.com/problems/unique-morse-code-words/discuss/120682/Kt-Js-Py3-Cpp-Seen
 */

class Solution {
    fun uniqueMorseRepresentations(A: Array<String>): Int {
        var m = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        var seen = mutableSetOf<String>()
        A.forEach { word ->
            var encoded = ""
            word.forEach { c ->
                encoded += m[c - 'a']
            }
            seen.add(encoded)
        }
        return seen.size
    }
}
