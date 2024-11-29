package calculator.controller;

import calculator.config.IoConfig;
import calculator.domain.Calculator;
import calculator.domain.Separator;
import calculator.io.InputHandler;
import calculator.io.InputView;
import calculator.io.OutputView;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private final InputHandler inputHandler;

    public Controller(IoConfig ioConfig, InputHandler inputHandler) {

        this.inputView = ioConfig.getInputView();
        this.outputView = ioConfig.getOutputView();
        this.inputHandler = inputHandler;
    }

    public void run() {
        turnOnCalculator();
    }

    private void turnOnCalculator() {
        List<Integer> numbers = getValidNumbers();
        long sum = getSum(numbers);
        outputView.printSumResult(sum);
    }

    private List<Integer> getValidNumbers() {
        return inputHandler.handleInputWithRetry(() -> {
            String input = inputView.readInput();
            return getNumbers(new Separator(), input);
        });
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
