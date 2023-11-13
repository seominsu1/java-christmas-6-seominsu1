package christmas.domain.menu;

import java.util.Arrays;
import java.util.Optional;

public enum Food {

    ONIONSOUP("양송이수프",6000),
    TAPAS("타파스",5500),
    CAESARSALAD("시저샐러드",8000),
    TBONESTEAK("티본스테이크",55000),
    BARBEQUERIB("바비큐립",54000),
    SEAFOODPASTA("해산물파스타",35000),
    CHRISTMASPASTA("크리스마스파스타",25000),
    CHOCOLATECAKE("초코케이크",15000),
    ICECREAM("아이스크림",5000),
    DIETCOKE("제로콜라",3000),
    REDWINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000),
    EMPTY("없음",0);

    private String name;
    private int price;

    Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static int getPriceByName(String menu) {
        Optional<Food> findByName = getMenusByName(menu);
        return findByName.map(Food::getPrice).orElseGet(EMPTY::getPrice);
    }

    public static Optional<Food> getMenusByName(String menu) {
        return Arrays.stream(Food.values())
                .filter(food -> food.getName().equals(menu))
                .findAny();
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
