package calculator;

import calculator.config.Config;
import calculator.config.IoConfig;
import calculator.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Controller controller = new Controller(
                new IoConfig(new Config())
        );
        controller.run();
    }
}
