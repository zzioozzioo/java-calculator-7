package calculator.io;

import calculator.io.reader.Reader;
import calculator.io.writer.Writer;

public class InputView {

    private final Reader reader;
    private final Writer writer;
    private final InputValidator validator;

    public InputView(Reader reader, Writer writer, InputValidator validator) {
        this.reader = reader;
        this.writer = writer;
        this.validator = validator;
    }

    public String readInput() {
        writer.write("덧셈할 문자열을 입력해 주세요.\n");
        String input = reader.readLine();
        validator.validateEmptyInput(input);
        return input;
    }
}
