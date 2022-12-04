package com.adventofcode2022.day2

enum class RockPaperScissors(code: Char, strategy: Char, val points: Int) {
    ROCK('A','X', 1),
    PAPER('B', 'Y', 2),
    SCISSORS('C', 'Z', 3)
}