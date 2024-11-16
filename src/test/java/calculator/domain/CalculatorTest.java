package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 숫자를_더할_수_있다() {
        //given
        List<Integer> numbers = List.of(3, 4, 1);
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(8);
    }
}