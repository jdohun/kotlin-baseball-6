package baseball.domain.model

data class Answer private constructor(private val singleNumbers: List<SingleNumber>) {
    companion object {
        const val LIMIT_ANSWER_SIZE = 3

        fun from(singleNumbers: List<SingleNumber>): Answer {
            validate(singleNumbers)
            return Answer(singleNumbers)
        }

        private fun validate(singleNumbers: List<SingleNumber>): Unit {
            validateSize(singleNumbers)
            validateDuplication(singleNumbers)
        }

        private fun validateSize(singleNumbers: List<SingleNumber>): Unit {
            if (singleNumbers.size > LIMIT_ANSWER_SIZE) {
                throw IllegalArgumentException("${LIMIT_ANSWER_SIZE}개의 숫자를 가져야 합니다.")
            }
        }

        private fun validateDuplication(singleNumbers: List<SingleNumber>): Unit {
            if (HashSet<SingleNumber>(singleNumbers).size != LIMIT_ANSWER_SIZE) {
                throw IllegalArgumentException("중복된 숫자가 존재합니다.")
            }
        }
    }
}