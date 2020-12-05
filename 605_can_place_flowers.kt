/*
 * 605. Can Place Flowers
 *
 * Q: https://leetcode.com/problems/can-place-flowers/
 * A: https://leetcode.com/problems/can-place-flowers/discuss/103899/Kt-Js-Py3-Cpp-Greedy-Linear-Scan
 */

class Solution {
    fun canPlaceFlowers(A: IntArray, K: Int): Boolean {
        var N = A.size
        if (K == 0) return true
        if (N == 0) return false
        if (N == 1) return A[0] == 0 && K == 1
        var planted = 0
        var plant = { i: Int -> A[i] = 1; ++planted }
        if (A[0] + A[1] == 0)
            plant(0)                              // 🌸 👈 left-most position 0
        for (i in 1..N - 2)
            if (A[i - 1] + A[i] + A[i + 1] == 0)
                plant(i)                          // 👉 🌸 👈 middle positions 1..N - 2
        if (A[N - 2] + A[N - 1] == 0)
            plant(N - 1)                          // 👉 🌸 right-most position N - 1
        return K <= planted
    }
}
