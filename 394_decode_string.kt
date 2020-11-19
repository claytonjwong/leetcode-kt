/*
 * 394. Decode String
 *
 * Q: https://leetcode.com/problems/decode-string/
 * A: https://leetcode.com/problems/decode-string/discuss/941684/Kt-Js-Py3-Cpp-Stack
 */

class Solution {
    fun decodeString(encoded: String): String {
        var freq = ""
        var word = ""
        var s = ArrayDeque<String>()
        encoded.forEach { c ->
            if (c == '[') {
                s.push(word); s.push(freq)
                freq = ""; word = ""
            }
            if (c == ']') {
                var last_freq = s.pop()
                var last_word = s.pop()
                word = last_word + word.repeat(last_freq.toInt())
            }
            if (c.isDigit())  freq += c
            if (c.isLetter()) word += c
        }
        return word
    }
}
