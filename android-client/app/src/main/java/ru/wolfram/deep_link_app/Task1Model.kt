package ru.wolfram.deep_link_app

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Task1Model {
    companion object {
        private const val MOD = 998244353
    }

    suspend fun calculate(p: Int?, q: Int?, n: Long?): Int? {
        return withContext(Dispatchers.Default) {
            if (p == null || q == null || n == null || n < 0) {
                return@withContext null
            }
            requireNotNull(p)
            requireNotNull(q)
            requireNotNull(n)
            when (n) {
                0L -> 2
                1L -> -p
                else -> {
                    val pow = pow(
                        arrayOf(
                            intArrayOf(-p, -q),
                            intArrayOf(1, 0)
                        ),
                        n - 1,
                        MOD
                    )
                    with(
                        requireNotNull(pow)
                    ) {
                        ((-get(0)[0] * p) % MOD + (get(0)[1] * 2) % MOD) % MOD
                    }
                }
            }
        }
    }

    private fun pow(mat: Array<IntArray>, n: Long, mod: Int): Array<IntArray>? {
        if (n < 0) {
            return null
        }
        return when (n) {
            0L -> arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )

            1L -> mat
            2L -> mul2(mat, mat, mod)
            else -> {
                if (n % 2 == 0L) {
                    val half = pow(mat, n / 2, mod)
                    requireNotNull(half)
                    pow(half, 2, mod)
                } else {
                    val almostHalf = pow(mat, (n - 1) / 2, mod)
                    requireNotNull(almostHalf)
                    val nOne = mul2(almostHalf, almostHalf, mod)
                    mul2(nOne, mat, mod)
                }
            }
        }
    }

    private fun mul2(mat1: Array<IntArray>, mat2: Array<IntArray>, mod: Int): Array<IntArray> {
        return arrayOf(
            intArrayOf(
                ((mat1[0][0] * mat2[0][0]) % mod + (mat1[0][1] * mat2[1][0]) % mod) % mod,
                ((mat1[0][0] * mat2[0][1]) % mod + (mat1[0][1] * mat2[1][1]) % mod) % mod
            ),
            intArrayOf(
                ((mat1[1][0] * mat2[0][0]) % mod + (mat1[1][1] * mat2[1][0]) % mod) % mod,
                ((mat1[1][0] * mat2[0][1]) % mod + (mat1[1][1] * mat2[1][1]) % mod) % mod
            )
        )
    }
}