package com.adventofcode2022.day4

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

fun solutionDay4 () {
    val result = File("${RESOURCES_BASE_PATH}/day_4.txt").readLines()
        .map { line -> eitherRangeIsContainedInTheOther(line) }
        .filter { b -> b }
        .size

    print(result)
}

private fun eitherRangeIsContainedInTheOther(line: String): Boolean {
    val parts: List<String> = line.split(',')
    val firstNumbersPair = parts[0].split('-').map { str -> str.toInt() }
    val secondNumbersPair = parts[1].split('-').map { str -> str.toInt() }

    val firstRange = firstNumbersPair[0]..firstNumbersPair[1]
    val secondRange = secondNumbersPair[0]..secondNumbersPair[1]

    return solutionPart2(secondNumbersPair, firstRange, firstNumbersPair, secondRange)
}

private fun solutionPart1(
    secondNumbersPair: List<Int>,
    firstRange: IntRange,
    firstNumbersPair: List<Int>,
    secondRange: IntRange
) =
    (secondNumbersPair[0] in firstRange && secondNumbersPair[1] in firstRange) || (firstNumbersPair[0] in secondRange && firstNumbersPair[1] in secondRange)

private fun solutionPart2(
    secondNumbersPair: List<Int>,
    firstRange: IntRange,
    firstNumbersPair: List<Int>,
    secondRange: IntRange
) =
    secondNumbersPair[0] in firstRange || secondNumbersPair[1] in firstRange || firstNumbersPair[0] in secondRange || firstNumbersPair[1] in secondRange