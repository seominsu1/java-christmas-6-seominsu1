package christmas.domain.menu;

import java.util.List;

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
}
