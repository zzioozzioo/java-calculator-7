package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final Pattern PATTERN = Pattern.compile("//(.*?)\\\\n");
    public static final String DEFAULT_SEPARATOR = ",|:";


    public String findSeparator(String input) {
        String separator = "";
        Matcher matcher = PATTERN.matcher(input); // 정규식과 일치하면 true
        if (matcher.find()) {
            separator = matcher.group(1); // 커스텀 구분자에 해당하는 문자 반환
        }
        if (separator.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 합니다.");
        }
        if (separator.length() == 1) {
            separator = "|" + separator;
        }
        return DEFAULT_SEPARATOR + separator;
    }

    public List<Integer> separateNumber(String input, String separator) {
        input = removeWithoutCalculationTarget(input, separator);
        try {
            return getNumbers(input, separator);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 계산할 수 있습니다.");
        }
    }

    private String removeWithoutCalculationTarget(String input, String separator) {
        return input.substring(5);
    }

    private static List<Integer> getNumbers(String input, String separator) {
        List<Integer> intNumbers = new ArrayList<>();
        List<String> strNumbers = Arrays.asList(input.split(separator));
        for (String number : strNumbers) {
            intNumbers.add(Integer.parseInt(number));
        }
        return intNumbers;
    }
}
