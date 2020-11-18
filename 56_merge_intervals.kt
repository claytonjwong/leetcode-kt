/*
 * 56. Merge Intervals
 *
 * Q: https://leetcode.com/problems/merge-intervals/
 * A: https://leetcode.com/problems/merge-intervals/discuss/940348/Kt-Js-Py3-Cpp-Sort-A-%2B-Track-Overlaps-via-Last-End
 */

class Solution {
    fun merge(A: Array<IntArray>): Array<IntArray> {
        A.sortWith(Comparator{ a: IntArray, b: IntArray -> if (a[0] == b[0]) a[1].compareTo(b[1]) else a[0].compareTo(b[0]) })
        var ans = mutableListOf<IntArray>(A[0])
        A.forEach { (beg, end) ->
            var lastIndex = ans.lastIndex
            var lastEnd = ans[lastIndex][1]
            if (beg <= lastEnd)
                ans[lastIndex][1] = Math.max(lastEnd, end)  // overlap
            else
                ans.add(intArrayOf(beg, end))               // no overlap
        }
        return ans.toTypedArray()
    }
}
