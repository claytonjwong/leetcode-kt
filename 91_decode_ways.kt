/*
 * 91. Decode Ways
 *
 * Q: https://leetcode.com/problems/decode-ways/
 * A: https://leetcode.com/problems/decode-ways/discuss/117143/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// top-down
class Solution {
    fun numDecodings(s: String): Int {
        var N = s.length
        var ok = { x: Int -> x in 1..26 }
        fun go(i: Int = 0): Int {
            if (i == N)
                return 1
            var cnt = 0
            var one = "${s[i]}".toInt()
            var two = if (one != 0 && i + 1 < N) ("${s[i]}${s[i + 1]}").toInt() else 0
            if (ok(one)) cnt += go(i + 1)
            if (ok(two)) cnt += go(i + 2)
            return cnt
        }
        return go()
    }
}

// top-down with memo
class Solution {
    fun numDecodings(s: String): Int {
        var m = mutableMapOf<Int, Int>()
        var N = s.length
        var ok = { x: Int -> x in 1..26 }
        fun go(i: Int = 0): Int {
            if (m.contains(i))
                return m[i]!!
            if (i == N)
                return 1
            m[i] = 0
            var one = "${s[i]}".toInt()
            var two = if (one != 0 && i + 1 < N) ("${s[i]}${s[i + 1]}").toInt() else 0
            if (ok(one)) m[i] = m[i]!! + go(i + 1)
            if (ok(two)) m[i] = m[i]!! + go(i + 2)
            return m[i]!!
        }
        return go()
    }
}

// bottom-up
class Solution {
    fun numDecodings(s: String): Int {
        var N = s.length
        var dp = IntArray(N + 2)
        dp[N] = 1
        var ok = { x: Int -> x in 1..26 }
        for (i in N - 1 downTo 0) {
            var one = "${s[i]}".toInt()
            var two = if (one != 0 && i + 1 < N) "${s[i]}${s[i + 1]}".toInt() else 0
            if (ok(one)) dp[i] += dp[i + 1]
            if (ok(two)) dp[i] += dp[i + 2]
        }
        return dp[0]
    }
}

// bottom-up mem-opt
class Solution {
    fun numDecodings(s: String): Int {
        var N = s.length
        var a = 0
        var b = 1
        var c = 0
        var ok = { x: Int -> x in 1..26 }
        for (i in N - 1 downTo 0) {
            var one = "${s[i]}".toInt()
            var two = if (one != 0 && i + 1 < N) "${s[i]}${s[i + 1]}".toInt() else 0
            a = 0
            if (ok(one)) a += b
            if (ok(two)) a += c
            c = b; b = a
        }
        return a
    }
}
