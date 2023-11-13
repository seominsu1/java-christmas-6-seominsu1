package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DecemberTest {
    @DisplayName("주중/주말 인지 확인하는 기능")
    @Test
    void isWeekdayOrWeekend() {
        int date = 25;
        December weekday = December.WEEKDAY;

        assertThat(weekday.isWeekday(date)).isTrue();
    }

    @DisplayName("주중/주말 문자열 반환")
    @Test
    void getType() {
        December weekday = December.WEEKDAY;
        String expected = "주중";

        assertThat(weekday.getType()).isEqualTo(expected);
    }

}