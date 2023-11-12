package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @DisplayName("크리스마스 할인이 적용되는지")
    @Test
    void applyChristmasDiscount() {
        int date = 25;
        Discount discount = new Discount(date);

        assertThat(discount.isChristmasDiscount()).isTrue();
    }

    @DisplayName("크리스마스 할인금액 반환되는지")
    @Test
    void calculateChristmasDiscount() {
        int date = 25;
        Discount discount = new Discount(date);
        int expectedDiscountMoney = 3400;

        assertThat(discount.calculateChristmasDiscount()).isEqualTo(expectedDiscountMoney);
    }

    @DisplayName("평일인지 주말인지 확인하는 기능")
    @Test
    void isWeekdayOrWeekend() {
        int date = 25;
        Discount discount = new Discount(date);
        String expectedType = "주중";

        assertThat(discount.isWeekOrWeekend()).isEqualTo(expectedType);
    }

    @DisplayName("특별 이벤트 날인지 확인하는 기능")
    @Test
    void isSpecialDiscountDay() {
        int date = 25;
        Discount discount = new Discount(date);

        assertThat(discount.isSpecialDiscount()).isTrue();
    }
}