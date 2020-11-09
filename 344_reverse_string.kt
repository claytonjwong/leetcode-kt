/*
 * 344. Reverse String
 *
 * Q: https://leetcode.com/problems/reverse-string/
 * A: https://leetcode.com/problems/reverse-string/discuss/670042/Kt-Js-Py3-Cpp-Easy-or-Hard
 */

// easy
class Solution {
    fun reverseString(s: CharArray): Unit {
        s.reverse()
    }
}

// hard
class Solution {
    fun reverseString(s: CharArray): Unit {
        var N = s.size
        for (i in 0 until N / 2)
            s[i] = s[N - 1 - i].also { s[N - 1 - i] = s[i] }
    }
}
