package christmas.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    @DisplayName("음식이름으로 해당 음식 가격 반환")
    @Test
    void findPriceByName() {
        String name = "티본스테이크";
        int expected = 55000;

        assertThat(Food.getPriceByName(name)).isEqualTo(expected);
    }
    @DisplayName("음식이름으로 해당 음식이 존재하는지")
    @Test
    void findExistingFoodByName() {
        String name = "티본스테이크";

        assertThat(Food.getMenusByName(name)).isNotEmpty();
    }
}