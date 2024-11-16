package calculator.config;

import calculator.io.InputValidator;
import calculator.io.InputView;
import calculator.io.OutputView;

public class IoConfig {

    private final InputView inputView;
    private final OutputView outputView;

    public IoConfig(Config config) {
        this.inputView = new InputView(
                config.getReader(),
                config.getWriter(),
                new InputValidator()
        );
        this.outputView = new OutputView(
                config.getWriter()
        );
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}
