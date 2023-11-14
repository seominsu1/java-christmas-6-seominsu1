package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum December {

    WEEKDAY("주중", List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)),
    WEEKEND("주말", List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));

    private String type;
    private List<Integer> days;

    December(String type, List<Integer> days) {
        this.type = type;
        this.days = days;
    }

    public static Optional<December> findDiscountType(int day) {
        return Arrays.stream(December.values())
                .filter(type -> type.isWeekday(day))
                .findAny();
    }

    public boolean isWeekday(int day) {
        return days.stream()
                .anyMatch(decemberDay -> decemberDay == day);
    }

    public String getType() {
        return type;
    }
}
