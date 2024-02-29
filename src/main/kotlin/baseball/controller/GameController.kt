package baseball.controller

import baseball.domain.AutoAnswerGenerator
import baseball.domain.model.Answer
import baseball.dto.ComparisonResult
import baseball.view.inputView.InputView
import baseball.view.inputView.util.InputParser
import baseball.view.outputView.OutputView
import camp.nextstep.edu.missionutils.Console

class GameController {
    private val inputView: InputView = InputView
    private val inputParser: InputParser = InputParser
    private val outputView: OutputView = OutputView
    private val autoAnswerGenerator: AutoAnswerGenerator = AutoAnswerGenerator

    fun run() {
        outputView.printStart()
        try {
            do {
                gameStart()
            } while (restart())
        } finally {
            Console.close()
        }
    }

    private fun gameStart(): Unit {
        val autoAnswer: Answer = autoAnswerGenerator.generate()
        do {
            val userAnswer: Answer = inputParser.parseAnswer(inputView.readAnswer())
            val result: ComparisonResult = autoAnswer.compare(userAnswer)
            outputView.printResult(result)
        } while (!result.isCorrect)
        outputView.printGameOver()
    }

    private fun restart(): Boolean {
        return inputParser.parseRestart(inputView.readRestart())
    }
}