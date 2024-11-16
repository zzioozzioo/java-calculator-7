package calculator.controller;

import calculator.config.IoConfig;
import calculator.domain.Calculator;
import calculator.domain.Separator;
import calculator.io.InputView;
import calculator.io.OutputView;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(IoConfig ioConfig) {

        this.inputView = ioConfig.getInputView();
        this.outputView = ioConfig.getOutputView();
    }

    public void run() {
        turnOnCalculator();
    }

    private void turnOnCalculator() {
        while (true) {
            try {
                play();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void play() {
        Separator separator = new Separator();
        String input = inputView.readInput();
        List<Integer> numbers = getNumbers(separator, input);
        long sum = getSum(numbers);
        outputView.printSumResult(sum);
    }

    private List<Integer> getNumbers(Separator separator, String input) {
        input = separator.findSeparator(input);
        return separator.separateNumber(input);
    }

    private long getSum(List<Integer> numbers) {
        Calculator calculator = new Calculator();
        return calculator.calculate(numbers);
    }
}
