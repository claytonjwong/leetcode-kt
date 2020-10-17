/*
 * 187. Repeated DNA Sequences
 *
 * Q: https://leetcode.com/problems/repeated-dna-sequences/
 * A: https://leetcode.com/problems/repeated-dna-sequences/discuss/898609/Kt-Js-Py3-Cpp-Sliding-Window-%2B-Map
 */

class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        var m = mutableMapOf<String, Int>()
        var word = ArrayDeque<Char>()
        s.forEach { c ->
            if (word.size == 10)
                word.removeFirst()
            word.addLast(c)
            var key = word.joinToString("")
            m[key] = 1 + m.getOrDefault(key, 0)
        }
        return m.filter{ (word, cnt) -> 1 < cnt }.map{ (word, cnt) -> word }
    }
}
