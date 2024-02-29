package baseball.view.inputView.util

import baseball.domain.model.Answer
import baseball.domain.model.SingleNumber

object InputParser {
    const val RESTART: Int = 1
    const val GAME_OVER: Int = 2
    private val inputValidator: InputValidator = InputValidator

    fun parseAnswer(readAnswer: String): Answer {
        inputValidator.validateReadAnswer(readAnswer)
        return convertAnswer(readAnswer)
    }

    private fun convertAnswer(readAnswer: String): Answer {
        val codeZero: Int = '0'.code
        val inputNumbers: List<Int> = readAnswer.toCharArray().map { it.code - codeZero }
        val singleNumbers = inputNumbers.map { SingleNumber.from(it) }
        return Answer.from(singleNumbers)
    }

    fun parseRestart(readRestart: String): Boolean {
        inputValidator.validateReadRestart(readRestart)
        return readRestart.toInt() == RESTART
    }
}