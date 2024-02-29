package baseball.domain.model

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AnswerTest {
    companion object {
        @JvmStatic
        fun duplicateNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 1, 2)),
                Arguments.of(intArrayOf(1, 2, 2)),
                Arguments.of(intArrayOf(2, 1, 2)),
            )
        }

        @JvmStatic
        fun noThreeNumbers(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2)),
                Arguments.of(intArrayOf(1, 2, 3, 4)),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("duplicateNumbers")
    fun `중복 단일 숫자 객체 존재 시 예외 발생`(numbers: IntArray) {
        // Arrange
        val duplicateSingleNumbers = numbers.map { SingleNumber.from(it) }

        // Act & Assert
        assertThrows<IllegalArgumentException> { Answer.from(duplicateSingleNumbers) }
    }

    @ParameterizedTest
    @MethodSource("noThreeNumbers")
    fun `단일 숫자 객체 리스트의 원소 개수가 3개가 아니면 예외 발생`(numbers: IntArray) {
        // Arrange
        val noThreeNumbers = numbers.map { SingleNumber.from(it) }

        // Act & Assert
        assertThrows<IllegalArgumentException> { Answer.from(noThreeNumbers) }
    }

    @Test
    fun `중복 없는 단일 숫자 객체 3개 리스트 예외 발생하지 않음`() {
        // Arrange
        val validateNumbers = listOf<SingleNumber>(
            SingleNumber.from(1),
            SingleNumber.from(2),
            SingleNumber.from(3),
        )

        // Act & Assert
        assertThatCode { Answer.from(validateNumbers) }.doesNotThrowAnyException()
    }
}