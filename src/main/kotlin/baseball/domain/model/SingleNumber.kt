package baseball.domain.model

data class SingleNumber private constructor(private val number: Int) {
    companion object {
        const val RANGE_START = 1
        const val RANGE_END = 9

        fun from(number: Int): SingleNumber {
            validate(number)
            return SingleNumber(number)
        }

        private fun validate(number: Int): Unit {
            if (!validateRange(number)) {
                throw IllegalArgumentException("입력 가능한 숫자의 범위는 $RANGE_START ~ $RANGE_END 입니다.")
            }
        }

        private fun validateRange(number: Int): Boolean {
            return number in RANGE_START..RANGE_END
        }
    }
}