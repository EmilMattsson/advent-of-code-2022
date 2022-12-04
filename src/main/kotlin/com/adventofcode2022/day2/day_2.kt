package com.adventofcode2022.day2

import com.adventofcode2022.day2.RockPaperScissors.*
import com.adventofcode2022.day2.RoundResult.*
import java.io.File

fun solutionDay2 () {
    var totalScore = 0
    val rounds: MutableList<Round> = mutableListOf()
    File("src/main/resources/day_2.txt").forEachLine { line: String ->
        rounds.add(Round(from(line[0]), from(line[2])))
    }
    rounds.forEach { round: Round ->
        val result: RoundResult = when(round.strategyShape) {
            ROCK -> resultForRock(round.opponentShape)
            PAPER -> resultForPaper(round.opponentShape)
            SCISSORS -> resultForScissors(round.opponentShape)
        }
        totalScore += result.points + round.strategyShape.points
    }
    println(totalScore)
}

fun from(char: Char): RockPaperScissors =
    when(char) {
        'A', 'X' -> ROCK
        'B', 'Y' -> PAPER
        'C', 'Z' -> SCISSORS
        else -> ROCK
    }

fun resultForRock(opponentShape: RockPaperScissors): RoundResult =
    when(opponentShape) {
        ROCK -> DRAW
        PAPER -> LOSE
        SCISSORS -> WIN
    }

fun resultForPaper(opponentShape: RockPaperScissors): RoundResult =
    when(opponentShape) {
        ROCK -> WIN
        PAPER -> DRAW
        SCISSORS -> LOSE
    }

fun resultForScissors(opponentShape: RockPaperScissors): RoundResult =
    when(opponentShape) {
        ROCK -> LOSE
        PAPER -> WIN
        SCISSORS -> DRAW
    }
