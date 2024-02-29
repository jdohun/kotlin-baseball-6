package baseball.domain

import baseball.domain.model.Answer
import baseball.domain.model.SingleNumber
import camp.nextstep.edu.missionutils.Randoms

object AutoAnswerGenerator {
    fun generate(): Answer {
        val threeRandomNumbers: List<Int> = generateThreeUniqueRandomNumbers()
        val singleNumbers: List<SingleNumber> = threeRandomNumbers.map { SingleNumber.from(it) }
        return Answer.from(singleNumbers)
    }

    private fun generateThreeUniqueRandomNumbers(): List<Int> {
        val threeRandomNumbers = mutableListOf<Int>()
        while (threeRandomNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!threeRandomNumbers.contains(randomNumber)) {
                threeRandomNumbers.add(randomNumber)
            }
        }
        return threeRandomNumbers
    }
}