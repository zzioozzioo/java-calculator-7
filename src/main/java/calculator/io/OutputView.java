package calculator.io;

import calculator.io.writer.Writer;

public class OutputView {

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printSumResult(long sum) {
        writer.write("결과 : " + sum + "\n");
    }
}
