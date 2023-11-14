package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("총주문 금액 계산 기능")
    @Test
    void calculateAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 3);
        menus.put("양송이스프", 5);
        menus.put("티본스테이크", 1);
        int expected = 94000;

        Calculator calculator = new Calculator(menus);
        calculator.calculateAmount();

        assertThat(calculator.getAmount()).isEqualTo(expected);
    }

    @DisplayName("평일 할인금액 계산 기능")
    @Test
    void calculateWeekDayDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 3);
        menus.put("초코케이크", 2);
        menus.put("아이스크림", 3);
        menus.put("티본스테이크", 1);
        int expected = 2023 * 5;

        Calculator calculator = new Calculator(menus);
        calculator.calculateWeekDayDiscount();

        assertThat(calculator.getWeekDayDiscount()).isEqualTo(expected);
    }

    @DisplayName("주말 할인금액 계산 기능")
    @Test
    void calculateWeekendDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("제로콜라", 3);
        menus.put("초코케이크", 2);
        menus.put("바베큐립", 3);
        menus.put("티본스테이크", 1);
        int expected = 2023 * 4;

        Calculator calculator = new Calculator(menus);
        calculator.calculateWeekendDiscount();

        assertThat(calculator.getWeekendDiscount()).isEqualTo(expected);
    }

    @DisplayName("크리스마스디데이 할인금액 계산 기능")
    @Test
    void calculateChristmasDdayDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("초코케이크", 2);
        menus.put("바베큐립", 3);
        menus.put("티본스테이크", 1);
        int amount = 3400;

        Calculator calculator = new Calculator(menus);
        calculator.calculateChristmasDdayDiscount(amount);

        assertThat(calculator.getChristmasDdayDiscount()).isEqualTo(amount);
    }

    @DisplayName("특별 할인금액 계산 기능")
    @Test
    void calculateSpecialDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("초코케이크", 2);
        menus.put("바베큐립", 3);
        menus.put("티본스테이크", 1);
        int expected = 1000;

        Calculator calculator = new Calculator(menus);
        calculator.calculateSpecialDiscount();

        assertThat(calculator.getSpecialDiscount()).isEqualTo(expected);
    }

    @DisplayName("증정 이벤트 할인금액 계산 기능")
    @Test
    void calculatePresentationDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("초코케이크", 2);
        menus.put("바베큐립", 3);
        menus.put("티본스테이크", 5);
        int expected = 25000;

        Calculator calculator = new Calculator(menus);
        calculator.calculateAmount();

        assertThat(calculator.isPresentationDiscount()).isTrue();
        assertThat(calculator.getPresentationDiscount()).isEqualTo(expected);
    }

    @DisplayName("총 할인금액 계산 기능")
    @Test
    void getDiscountAmount() {
        Map<String, Integer> menus = new HashMap<>();
        menus.put("초코케이크", 2);
        menus.put("바베큐립", 3);
        menus.put("티본스테이크", 5);
        int expected = 2023 * 5 + 2023 * 3 + 1000 + 25000 + 3400;

        Calculator calculator = new Calculator(menus);
        calculator.calculateAmount();
        calculator.calculateWeekendDiscount();
        calculator.calculateSpecialDiscount();
        calculator.isPresentationDiscount();
        calculator.calculateChristmasDdayDiscount(3400);

        assertThat(calculator.getDiscountAmount()).isEqualTo(expected);
    }
}