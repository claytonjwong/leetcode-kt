/*
 * 454. 4Sum II
 *
 * Q: https://leetcode.com/problems/4sum-ii/
 * A: https://leetcode.com/problems/4sum-ii/discuss/975519/Kt-Js-Py3-Cpp-Map
 */

class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        var cnt = 0
        var m = mutableMapOf<Int, Int>()
        A.forEach{ a ->
            B.forEach{ b ->
                m[a + b] = 1 + m.getOrDefault(a + b, 0)
            }
        }
        C.forEach{ c ->
            D.forEach{ d ->
                cnt += m.getOrDefault(-(c + d), 0)
            }
        }
        return cnt
    }
}
