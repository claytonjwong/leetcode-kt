/*
 * 1431. Kids With the Greatest Number of Candies
 *
 * Q: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * A: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/discuss/611820/Kt-Js-Py3-Cpp-1-Liner-solutions
 */

class Solution {
    fun kidsWithCandies(A: IntArray, K: Int): BooleanArray {
        return A.map{ A.max()!! <= it + K }.toBooleanArray()
    }
}

