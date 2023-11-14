package christmas.exception;

public class InvalidVisitingDayFormatException extends IllegalArgumentException {
    private static final String INVALID_VISITING_DAY_FORMAT_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public InvalidVisitingDayFormatException() {
        super(INVALID_VISITING_DAY_FORMAT_MESSAGE);
    }
}
