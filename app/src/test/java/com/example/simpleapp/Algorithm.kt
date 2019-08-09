package com.example.simpleapp

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.abs
import kotlin.random.Random

class Algorithm {


    fun getZeroOrOne() = Random.nextInt(2)

    /**
     *  0 부터 max_number - 1 사이의 랜덤값을 리턴하는 함수( get_random)를 구현하시 면 됩니다.
     *
     */
    fun getRandom(maxNumber: Int): Int {

        if (maxNumber <= 0 || maxNumber > Int.MAX_VALUE) {
            throw IllegalArgumentException("maxNumber 은 0보다 크고 MaxValue 보다 같거나 작아야함 ")
        }

        var result = Int.MAX_VALUE

        while (result > maxNumber - 1) {
            val bitArray = Integer.toBinaryString(maxNumber)

            val randomBitArray = bitArray.map {
                getZeroOrOne()
            }

            result = randomBitArray.reversed()
                .mapIndexed { index, c ->
                    if (c == 1) {
                        if (index == 0) {
                            1
                        } else {
                            var n = 1
                            repeat(index) { n *= 2 }
                            n
                        }
                    } else {
                        0
                    }
                }.sum()
        }

        return result
    }

    @Test
    fun `get_zero_or_one Test`() {
        var zero = 0
        var one = 1

        repeat(TIMES) {
            if (Random.nextInt(2) == 0) {
                zero++
            } else {
                one++
            }
        }

        println("zero: $zero, one: $one")
    }

    @Test
    fun `byte int bit size`() {
        println(Byte.SIZE_BITS)
        println(Byte.SIZE_BYTES)
        println(Int.SIZE_BITS)
        println(Int.SIZE_BYTES)
    }


    val TIMES = 100_000


    @Test
    fun `example 1`() {

        val input = 5

        val arr = IntArray(input) { 0 }

        repeat(TIMES) {
            val output = getRandom(input)
            val expected = 0 until input

            arr[output]++

            assertTrue(expected.contains(output))
        }

        arr.forEachIndexed { index, i ->

            val errorRange = String.format("%.5f", abs(TIMES/input - i)/ TIMES.toFloat())

            println(String.format("[%3s, %3s] 오차범위 : $errorRange", index, i))
        }

        println("크기 : ${arr.size}")

    }

    @Test
    fun `example 2`() {

        val input = 3

        val arr = IntArray(input) { 0 }

        repeat(TIMES) {
            val output = getRandom(input)
            val expected = 0 until input

            arr[output]++

            assertTrue(expected.contains(output))
        }

        arr.forEachIndexed { index, i ->

            val errorRange = String.format("%.5f", abs(TIMES/input - i)/ TIMES.toFloat())

            assertTrue(0.01f > errorRange.toFloat())

            println(String.format("[%3s, %3s] 오차범위 : $errorRange", index, i))
        }

        println("크기 : ${arr.size}")

    }

    @Test
    fun `example 3`() {

        val input = 100

        val arr = IntArray(input) { 0 }

        repeat(TIMES) {
            val output = getRandom(input)
            val expected = 0 until input

            arr[output]++

            assertTrue(expected.contains(output))
        }

        arr.forEachIndexed { index, i ->

            val errorRange = String.format("%.5f", abs(TIMES/input - i)/ TIMES.toFloat())

            assertTrue(0.01f > errorRange.toFloat())

            println(String.format("[%3s, %5s] 오차범위 : $errorRange", index, i))
        }

        println("크기 : ${arr.size}")

    }


    @Test(expected = IllegalArgumentException::class)
    fun `input 0 test`() {
        getRandom(0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `input -1 test`() {
        getRandom(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `input MaxValue + 1 test`() {
        getRandom(Int.MAX_VALUE + 1)
    }

    @Test
    fun `input MaxValue test`() {
        val input = Int.MAX_VALUE

        val map = mutableMapOf<Int, Int>()

        repeat(TIMES) {
            val output = getRandom(input)
            val expected = 0 until input

            if (map.containsKey(output)) {
                map[output] = map[output]!!.plus(1)
            } else {
                map[output] = 1
            }

            assertTrue(expected.contains(output))
        }

        map.forEach {

            val errorRange = String.format("%.5f", abs(TIMES/input - it.value)/ TIMES.toFloat())

            assertTrue(0.01f > errorRange.toFloat())

            println(String.format("[%11s, %2s] 오차범위 : $errorRange", it.key, it.value))
        }

        println("크기 : ${map.size}")


    }

    private val MEGABYTE = 1024L * 1024L

    @Test
    fun oomTest() {
        val result: Long =  Int.SIZE_BYTES.toLong() * Int.MAX_VALUE

        val size = result / MEGABYTE

        println("$size MB")
    }

}
