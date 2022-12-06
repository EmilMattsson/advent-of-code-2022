package com.adventofcode2022.day3

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

val alphabetPointMap = getCharPointMap()

fun solutionPart1 () {
    val sum = getLinesFromInputFile()
        .map { line ->
            getCharPoint(line)
        }
        .sumOf { i -> i ?: 0 }

    println(sum)
}

fun solutionPart2 () {
    val sum = getLinesFromInputFile()
        .chunked(3)
        .map { lines ->
            getCharPointFrom(lines)
        }
        .sumOf { i -> i ?: 0 }

    println(sum)
}

private fun getLinesFromInputFile() = File("${RESOURCES_BASE_PATH}/day_3.txt").useLines { it.toList() }

private fun getCharPointFrom(lines: List<String>): Int? {
    val chars1 = lines[0].toCharArray().distinct()
    val chars2 = lines[1].toCharArray().distinct()
    val chars3 = lines[2].toCharArray().distinct()

    return alphabetPointMap[chars1.filter { char -> chars2.contains(char) && chars3.contains(char) }[0]]
}

private fun getCharPoint(line: String): Int? {
    val lineMiddleIndex = line.length - (line.length / 2)
    val firstCompartment = line.substring(0, lineMiddleIndex)
    val secondCompartment = line.substring(lineMiddleIndex)

    return alphabetPointMap[getCommonCharFromCompartments(Rucksack(firstCompartment, secondCompartment))[0]]
}

private fun getCommonCharFromCompartments(r: Rucksack) =
    r.secondCompartment.toCharArray().distinct().filter { char -> r.firstCompartment.toCharArray().contains(char) }

fun getCharPointMap(): Map<Char, Int> {
    return getCharPoints('A', 'Z', 27) + getCharPoints('a', 'z', 1)
}

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