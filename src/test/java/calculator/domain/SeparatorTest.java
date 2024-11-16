package calculator.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SeparatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1:2, 1:2", "//;\\n3;4, 3;4"})
    void 입력_문자열에서_숫자_추출_기능_테스트(String input, String actualResult) {
        //given
        Separator separator = new Separator();

        //when
        String expectedResult = separator.findSeparator(input);

        //then
        Assertions.assertThat(expectedResult).isEqualTo(actualResult);
    }

    @Test
    void 값을_입력하지_않은_경우_결과는_0이다() {
        //given
        String input = "";
        Separator separator = new Separator();

        //when
        separator.findSeparator(input);
        List<Integer> actualNumbers = separator.separateNumber(input);
        List<Integer> expectedNumbers = List.of(0);

        //then
        Assertions.assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

//    @Test
//    void 커스텀_구분자의_구분자만_입력하면_결과는_0이다() {
//        //given
//        String input = "//;\n";
//        Separator separator = new Separator();
//
//        //when
//        separator.findSeparator(input);
//        List<Integer> actualNumbers = separator.separateNumber(input);
//        List<Integer> expectedNumbers = List.of(0);
//
//        //then
//        Assertions.assertThat(actualNumbers).isEqualTo(expectedNumbers);
//    }

    @Test
    void 음수를_입력하면_예외가_발생한다() {
        //given
        String input = "-1,2,3";
        Separator separator = new Separator();

        separator.findSeparator(input);

        //when & then
        Assertions.assertThatThrownBy(() ->
                separator.separateNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자의_구분자가_정확하지_않으면_예외가_발생한다() {
        String input = "//;3;4";
        Separator separator = new Separator();

        separator.findSeparator(input);

        //when & then
        Assertions.assertThatThrownBy(() ->
                separator.separateNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자를_여러개_입력하면_예외가_발생한다() {
        String input = "//;^%\\n4;3^5";
        Separator separator = new Separator();

        //when & then
        Assertions.assertThatThrownBy(() ->
                separator.findSeparator(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
