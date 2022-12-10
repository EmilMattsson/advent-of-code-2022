package com.adventofcode2022.day5

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File
import java.util.LinkedList

fun solution () {
    val lines = File("${RESOURCES_BASE_PATH}/day_5.txt").useLines { it.toList() }
    val crateList: List<LinkedList<Char>> = createDataStructure()

    populateCrateList(lines, crateList)
    println(crateList)

    rearrangeCrates(lines, crateList)
    for (i in 0..crateList.lastIndex) {
        print(crateList[i][0])
    }
}

private fun rearrangeCrates(
    file: List<String>,
    crateList: List<LinkedList<Char>>
) {
    for (i in 10..file.lastIndex) {
        val lineParts = file[i].split(' ')
        val amountOfCrates = lineParts[1].toInt()
        val moveFrom = lineParts[3].toInt()
        val moveTo = lineParts[5].toInt()

        println("$amountOfCrates $moveFrom $moveTo")

        for (j in 1..amountOfCrates) {
            val crateToMove = crateList[moveFrom - 1].pop()

            println("moving crate $crateToMove from pile $moveFrom to $moveTo")

            crateList[moveTo - 1].push(crateToMove)
        }
    }
}

private fun populateCrateList(
    file: List<String>,
    crateList: List<LinkedList<Char>>
) {
    for (i in 7 downTo 0) {
        val line = file[i]

        for ((crateStack, j) in (1..file[i].length step 4).withIndex()) {
            val char = line[j]

            if (char != ' ') crateList[crateStack].push(char)
        }
    }
}

fun createDataStructure (): MutableList<LinkedList<Char>> {
    val list: MutableList<LinkedList<Char>> = mutableListOf()
    for (i in 1..9) list.add(LinkedList(mutableListOf()))

    return list
}