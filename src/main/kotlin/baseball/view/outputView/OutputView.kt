package baseball.view.outputView

import baseball.domain.model.Answer
import baseball.dto.ComparisonResult
import baseball.view.outputView.format.ComparisonResultFormat

object OutputView {
    private const val OUTPUT_START_MESSAGE: String = "숫자 야구 게임을 시작합니다."
    private const val OUTPUT_GAME_OVER: String = "${Answer.LIMIT_ANSWER_SIZE}개의 숫자를 모두 맞히셨습니다! 게임 종료"

    fun printStart(): Unit {
        println(OUTPUT_START_MESSAGE)
    }

    fun printResult(comparisonResult: ComparisonResult) {
        println(ComparisonResultFormat.getFormatByResult(comparisonResult))
    }

    fun printGameOver(): Unit {
        println(OUTPUT_GAME_OVER)
    }
}