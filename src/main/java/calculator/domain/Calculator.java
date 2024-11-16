package calculator.domain;

import java.util.List;

public class Calculator {


    public long calculate(List<Integer> numbers) {
        long sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
