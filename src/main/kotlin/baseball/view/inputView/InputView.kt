package baseball.view.inputView

import baseball.view.inputView.util.InputParser.GAME_OVER
import baseball.view.inputView.util.InputParser.RESTART
import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val INPUT_NUMBERS: String = "숫자를 입력해주세요 : "
    private const val INPUT_RESTART: String = "게임을 새로 시작하려면 ${RESTART}, 종료하려면 ${GAME_OVER}를 입력하세요."

    fun readAnswer(): String {
        print(INPUT_NUMBERS)
        return Console.readLine()
    }

    fun readRestart(): String {
        println(INPUT_RESTART)
        return Console.readLine()
    }
}