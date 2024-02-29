package baseball.view.inputView.util

import baseball.domain.model.Answer.Companion.LIMIT_ANSWER_SIZE
import baseball.domain.model.SingleNumber.Companion.RANGE_END
import baseball.domain.model.SingleNumber.Companion.RANGE_START
import baseball.view.inputView.util.InputParser.GAME_OVER
import baseball.view.inputView.util.InputParser.RESTART

object InputValidator {
    private val REGEX_ANSWER: Regex = Regex("^[${RANGE_START}-${RANGE_END}]{$LIMIT_ANSWER_SIZE}$")
    private val REGEX_RESTART: Regex = Regex("^[${RESTART}-${GAME_OVER}]$")

    fun validateReadAnswer(readAnswer: String): Unit {
        require(REGEX_ANSWER.matches(readAnswer)) { "정답 입력 형식에 맞지 않습니다." }
    }

    fun validateReadRestart(readRestart: String): Unit {
        require(REGEX_RESTART.matches(readRestart)) { "재시도 입력 형식에 맞지 않습니다." }
    }
}