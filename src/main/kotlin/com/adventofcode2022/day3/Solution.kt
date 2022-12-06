package com.adventofcode2022.day3

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

val bigCharPointMap = getCharPoints('A', 'Z', 27)
val charPointMap = getCharPoints('a', 'z', 1)

fun solution () {
    charPointMap.putAll(bigCharPointMap)

    val sum = File("${RESOURCES_BASE_PATH}/day_3.txt").useLines { it.toList() }
        .map { line ->
            val lineMiddleIndex = line.length - (line.length / 2)
            val firstCompartment = line.substring(0, lineMiddleIndex)
            val secondCompartment = line.substring(lineMiddleIndex)

            charPointMap[getCharFromBothCompartments(Rucksack(firstCompartment, secondCompartment))[0]]
        }
        .sumOf { i -> i ?: 0 }

    println(sum)
}

private fun getCharFromBothCompartments(r: Rucksack) =
    r.secondCompartment.toCharArray().distinct().filter { char -> r.firstCompartment.toCharArray().contains(char) }

fun getCharPoints(startChar: Char, endChar: Char, startValue: Int): MutableMap<Char, Int> {
    val charPointsMap: MutableMap<Char, Int> = mutableMapOf()

    var char = startChar
    var point = startValue
    while (char <= endChar) {
        charPointsMap[char] = point

        char++
        point++
    }
    return charPointsMap
}