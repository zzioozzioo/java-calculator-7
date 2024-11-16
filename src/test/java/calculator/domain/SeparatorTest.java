package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeparatorTest {
    @Test
    void 입력_문자열에서_구분자를_찾을_수_있다() {
        //given
        String input = "1:2";
        Separator separator = new Separator();

        //when
        String result = separator.findSeparator(input);

        //then
        Assertions.assertThat(result).isEqualTo(",|:");
    }

    @Test
    void 입력_문자열을_커스텀_구분자를_기준으로_분리한다() {
        //given
        String input = "//;\\n3;4";
        Separator separator = new Separator();

        //when
        String result = separator.findSeparator(input);

        //then
        Assertions.assertThat(result).isEqualTo(",|:|;");
    }

    @Test
    void 문자열을_구분자로_나눠_숫자를_추출한다() {
        //given
        String input = "//;\\n3;4";
        Separator separator = new Separator();

        //when
        String string = separator.findSeparator(input);
        List<Integer> expectedNumbers = List.of(3, 4);
        List<Integer> actualNumbers = separator.separateNumber(input, string);

        //then
        Assertions.assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }
}
