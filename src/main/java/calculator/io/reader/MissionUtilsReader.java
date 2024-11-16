package calculator.io.reader;

import camp.nextstep.edu.missionutils.Console;

public class MissionUtilsReader implements Reader {

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
