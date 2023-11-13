package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StarDayTest {

    @DisplayName("특별할인 날인지 확인하는 기능")
    @Test
    void isSpecialDiscountDay() {
        int date = 25;
        StarDay starDay = StarDay.Star;

        assertThat(starDay.isStarDay(date)).isTrue();
    }

    @DisplayName("특별/없음 문자열 반환")
    @Test
    void getType() {
        StarDay starDay = StarDay.Star;
        String expected = "특별";

        assertThat(starDay.getType()).isEqualTo(expected);
    }

}