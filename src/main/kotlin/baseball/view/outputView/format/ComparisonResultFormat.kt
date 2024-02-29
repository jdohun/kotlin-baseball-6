package baseball.view.outputView.format

import baseball.dto.ComparisonResult

enum class ComparisonResultFormat(private val message: String) {
    NOTHING("낫싱"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_AND_STRIKE("%d볼 %d스트라이크");

    companion object {
        fun getFormatByResult(comparisonResult: ComparisonResult): String {
            val ball = comparisonResult.ball
            val strike = comparisonResult.strike

            return when {
                ball == 0 && strike > 0 -> STRIKE.message.format(strike)
                ball > 0 && strike == 0 -> BALL.message.format(ball)
                ball > 0 && strike > 0 -> BALL_AND_STRIKE.message.format(ball, strike)
                else -> NOTHING.message
            }
        }
    }
}