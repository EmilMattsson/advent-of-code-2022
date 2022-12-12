package com.adventofcode2022.day6

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

fun solutionDay6Part1 () {
    val lines = File("$RESOURCES_BASE_PATH/day_6.txt").useLines { it.toList() }.stream()
        .map { str -> str.toList() }
        .findFirst()
        .get()
    val firstUniqueSequence = lines
        .windowed(4)
        .first { it.toSet().size > 3 }
    println(firstUniqueSequence)

    val indexOfFirstUniqueSequence = lines
        .windowed(4)
        .indexOf(firstUniqueSequence)
    println(indexOfFirstUniqueSequence)

    println(indexOfFirstUniqueSequence + 4)
}