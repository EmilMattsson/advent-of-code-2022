package com.adventofcode2022

import java.io.File

fun solution() {
    val list: MutableList<Int> = mutableListOf()
    var sum = 0
    File("src/main/resources/day_1.txt").forEachLine { line: String ->
        if (line.isBlank()) {
            list.add(sum)
            sum = 0
        } else {
            sum += line.toInt()
        }
    }

    list.sort()
    val lastIndex = list.lastIndex
    val mostCalories = list[lastIndex]
    val secondMost = list[lastIndex - 1]
    val thirdMost = list[lastIndex - 2]

    println(mostCalories)
    println(mostCalories + secondMost + thirdMost)
}