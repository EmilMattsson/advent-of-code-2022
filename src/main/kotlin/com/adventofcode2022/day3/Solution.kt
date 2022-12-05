package com.adventofcode2022.day3

import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

fun solution () {
    var file = File("${RESOURCES_BASE_PATH}/day_3.txt")

    println(file.length())
}