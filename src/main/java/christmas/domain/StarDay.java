package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum StarDay {

    Star("특별", List.of(3, 10, 17, 24, 25, 31)),
    EMPTY("없음", List.of());

    private String type;
    private List<Integer> days;

    StarDay(String type, List<Integer> days) {
        this.type = type;
        this.days = days;
    }

    public static Optional<StarDay> findSpecialDiscountDay(int day) {
        return Arrays.stream(StarDay.values())
                .filter(type -> type.isStarDay(day))
                .findAny();
    }

    public boolean isStarDay(int day) {
        return days.stream()
                .anyMatch(starDay -> starDay == day);
    }

    public String getType() {
        return type;
    }
}
