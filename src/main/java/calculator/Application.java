package calculator;

import calculator.config.Config;
import calculator.config.IoConfig;
import calculator.controller.Controller;
import calculator.io.InputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        IoConfig ioConfig = new IoConfig(new Config());
        Controller controller = new Controller(
                ioConfig, new InputHandler(ioConfig.getOutputView())
        );
        controller.run();
    }
}
