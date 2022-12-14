package com.adventofcode2022.day6

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

fun solutionDay6Part1 () {
    solutionDay6(4)
}

fun solutionDay6Part2() {
    solutionDay6(14)
}

fun solutionDay6 (numberOfUniqueCharsInStartPacket: Int) {
    val lines = File("$RESOURCES_BASE_PATH/day_6.txt").useLines { it.toList() }.stream()
        .map { str -> str.toList() }
        .findFirst()
        .get()
        .windowed(numberOfUniqueCharsInStartPacket)

    val firstUniqueSequence = lines
        .first { it.toSet().size > numberOfUniqueCharsInStartPacket - 1 }
    println(firstUniqueSequence)

    val indexOfFirstUniqueSequence = lines
        .indexOf(firstUniqueSequence)
    println(indexOfFirstUniqueSequence)

    println(indexOfFirstUniqueSequence + numberOfUniqueCharsInStartPacket)
}