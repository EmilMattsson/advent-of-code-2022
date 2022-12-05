package com.adventofcode2022.day2

import com.adventofcode2022.day2.RockPaperScissors.*
import com.adventofcode2022.day2.RoundOutcome.*
import com.adventofcode2022.util.RESOURCES_BASE_PATH
import java.io.File

fun solution () {
    var totalScore = 0
    val rounds: MutableList<Round> = mutableListOf()
    File("$RESOURCES_BASE_PATH/day_2.txt").forEachLine { line: String ->
        rounds.add(Round(shapeFrom(line[0]), desiredOutcomeFrom(line[2])))
    }
    rounds.forEach { round: Round ->
        totalScore += myShapeFrom(round.desiredOutcome, round.opponentShape).points + round.desiredOutcome.points
    }
    println(totalScore)
}

fun shapeFrom(char: Char): RockPaperScissors =
    when(char) {
        'A' -> ROCK
        'B' -> PAPER
        'C' -> SCISSORS
        else -> ROCK
    }

fun desiredOutcomeFrom(char: Char): RoundOutcome =
    when(char) {
        'X' -> LOSE
        'Y' -> DRAW
        'Z' -> WIN
        else -> LOSE
    }

fun resultForRock(opponentShape: RockPaperScissors): RoundOutcome =
    when(opponentShape) {
        ROCK -> DRAW
        PAPER -> LOSE
        SCISSORS -> WIN
    }

fun resultForPaper(opponentShape: RockPaperScissors): RoundOutcome =
    when(opponentShape) {
        ROCK -> WIN
        PAPER -> DRAW
        SCISSORS -> LOSE
    }

fun resultForScissors(opponentShape: RockPaperScissors): RoundOutcome =
    when(opponentShape) {
        ROCK -> LOSE
        PAPER -> WIN
        SCISSORS -> DRAW
    }

fun myShapeFrom(desiredOutcome: RoundOutcome, opponentShape: RockPaperScissors): RockPaperScissors =
    when (desiredOutcome) {
        LOSE -> when(opponentShape) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
        DRAW -> when(opponentShape) {
            ROCK -> ROCK
            PAPER -> PAPER
            SCISSORS -> SCISSORS
        }
        WIN -> when(opponentShape) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    }
