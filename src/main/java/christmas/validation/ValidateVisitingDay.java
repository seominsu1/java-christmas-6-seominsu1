package christmas.validation;

import christmas.exception.InvalidVisitingDayFormatException;

public class ValidateVisitingDay {

    public void validate(String input) {
        if (!input.matches("^[1-9]{1}$|[1-2]{1}[0-9]{1}$|3{1}[0-1]{1}$")) {
            throw new InvalidVisitingDayFormatException();
        }
    }
}
