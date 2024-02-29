package baseball.domain.model

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SingleNumberTest {

    @Test
    fun `1부터 9까지의 범위 테스트`() {
        // Act & Assert
        assertThatCode {
            for (i in 1..9) {
                SingleNumber.from(i)
            }
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 10])
    fun `범위를 벗어나는 숫자 전달 시 예외 발생`(number: Int) {
        // Act & Assert
        assertThrows<IllegalArgumentException> { SingleNumber.from(number) }
    }
}