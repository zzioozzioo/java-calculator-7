package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final Pattern PATTERN = Pattern.compile("//(.*?)\\\\n");
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static String TOTAL_SEPARATOR;

    public String findSeparator(String input) {
        String separator = "";
        Matcher matcher = PATTERN.matcher(input); // 정규식과 일치하면 true
        if (matcher.find()) {
            separator = matcher.group(1); // 커스텀 구분자에 해당하는 문자 반환
            separator = validateCustomSeparator(separator);
            input = removeWithoutCalculationTarget(input);
        }
        setTotalSeparator(DEFAULT_SEPARATOR + separator);
        return input;
    }

    private String validateCustomSeparator(String separator) {
        validate(separator);
        if (separator.length() == 1) {
            separator = "|" + separator;
        }
        return separator;
    }

    private static void validate(String separator) {
        if (separator.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 합니다. 다시 입력해 주세요.");
        }
        if (separator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않았습니다. 다시 입력해 주세요.");
        }
    }

    public List<Integer> separateNumber(String input) {
        try {
            return getNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 계산할 수 있습니다. 다시 입력해 주세요.");
        }
    }

    private String removeWithoutCalculationTarget(String input) {
        // TODO: 인덱스로 자르면 안되고, \n 전까지 잘라야 함
        return input.substring(5);
    }

    private static List<Integer> getNumbers(String input) {
        List<Integer> intNumbers = new ArrayList<>();
        String[] splitNumbers = input.split(TOTAL_SEPARATOR);
        for (String number : splitNumbers) {
            addValidNumberToList(number, intNumbers);
        }
        return intNumbers;
    }

    private static void addValidNumberToList(String number, List<Integer> intNumbers) {
        if (number.trim().isEmpty()) {
            number = "0";
        }
        int parsedInt = Integer.parseInt(number);
        if (parsedInt < 0) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다. 자연수만 입력해 주세요.");
        }
        intNumbers.add(parsedInt);
    }

    private void setTotalSeparator(String totalSeparator) {
        TOTAL_SEPARATOR = totalSeparator;
    }
}
