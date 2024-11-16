package calculator.io;

public class InputValidator {

    public void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("덧셈할 문자열을 입력해야 합니다. 다시 입력해 주세요.\n");
        }
    }
}
