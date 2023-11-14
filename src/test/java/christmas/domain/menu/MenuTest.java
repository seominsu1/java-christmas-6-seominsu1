package christmas.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @DisplayName("해당 음식이 디저트 메뉴 타입인지")
    @Test
    void isDessertMenu() {
        Food iceCream = Food.ICECREAM;

        assertThat(Menu.isDessert(iceCream)).isTrue();
    }

    @DisplayName("해당 음식이 메인 메뉴 타입인지")
    @Test
    void isMainMenu() {
        Food tboneSteak = Food.TBONESTEAK;

        assertThat(Menu.isMain(tboneSteak)).isTrue();
    }

    @DisplayName("해당 음식이 음료 메뉴 타입이 아닌지")
    @Test
    void isNotDrinkMenu() {
        Food caesarSalad = Food.CAESARSALAD;

        assertThat(Menu.isNotDrink(caesarSalad)).isTrue();
    }
}