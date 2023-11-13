package christmas.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Menu {
    APPETIZER("에피타이저", List.of(Food.ONIONSOUP, Food.TAPAS, Food.CAESARSALAD)),
    MAIN("메인", List.of(Food.TBONESTEAK, Food.BARBEQUERIB, Food.SEAFOODPASTA, Food.CHRISTMASPASTA)),
    DESSERT("디저트", List.of(Food.CHOCOLATECAKE, Food.ICECREAM)),
    DRINKS("음료", List.of(Food.DIETCOKE, Food.REDWINE, Food.CHAMPAGNE));

    private String type;
    private List<Food> menus;

    Menu(String type, List<Food> menus) {
        this.type = type;
        this.menus = menus;
    }

    public static boolean isDessert(Food food) {
        Optional<Menu> findByFood = Arrays.stream(Menu.values())
                .filter(type -> type.findType(food))
                .findAny();
        return findByFood.get().equals(Menu.DESSERT);
    }

    public static boolean isMain(Food food) {
        Optional<Menu> findByFood = Arrays.stream(Menu.values())
                .filter(type -> type.findType(food))
                .findAny();
        return findByFood.get().equals(Menu.MAIN);
    }

    public static boolean isNotDrink(Food food) {
        Optional<Menu> findByFood = Arrays.stream(Menu.values())
                .filter(type -> type.findType(food))
                .findAny();
        return !findByFood.get().equals(Menu.DRINKS);
    }

    public boolean findType(Food food) {
        return menus.stream()
                .anyMatch(type -> type == food);
    }
}
