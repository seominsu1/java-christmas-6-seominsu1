package christmas.exception;

public class InvalidOrderFormatException extends IllegalArgumentException{
    private static final String INVALID_ORDER_FORMAT_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InvalidOrderFormatException() {
        super(INVALID_ORDER_FORMAT_MESSAGE);
    }
}
