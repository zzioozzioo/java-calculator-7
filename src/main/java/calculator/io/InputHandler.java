package calculator.io;

import java.util.function.Supplier;

public class InputHandler {
    private final OutputView outputView;

    public InputHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T handleInputWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
