package christmas.domain;

import christmas.domain.menu.Food;
import christmas.domain.menu.Menu;

import java.util.Map;

public class Calculator {
    private Map<String, Integer> order;
    private int amount;
    private int weekDayDiscount;
    private int weekendDiscount;
    private int presentationDiscount;
    private int specialDiscount;
    private int christmasDdayDiscount;
    private int discountAmount;
    private int[] benefits;

    public Calculator(Map<String, Integer> order) {
        this.order = order;
        this.amount = 0;
        this.weekDayDiscount = 0;
        this.weekendDiscount = 0;
        this.presentationDiscount = 0;
        this.specialDiscount = 0;
        this.christmasDdayDiscount = 0;
        this.discountAmount = 0;
    }

    public void calculateAmount() {
        order.forEach((name, count) -> amount += Food.getPriceByName(name) * count);
    }

    public void calculateWeekDayDiscount() {
        order.forEach((name, count) -> {
            if (Menu.isDessert(Food.getMenusByName(name).get())) {
                weekDayDiscount += 2023 * count;
                discountAmount += 2023 * count;
            }
        });
    }

    public void calculateWeekendDiscount() {
        order.forEach((name, count) -> {
            if (Menu.isMain(Food.getMenusByName(name).get())) {
                weekendDiscount += 2023 * count;
                discountAmount += 2023 * count;
            }
        });
    }

    public void calculateSpecialDiscount() {
        specialDiscount += 1000;
        discountAmount += 1000;
    }

    public void calculateChristmasDdayDiscount(int ddayDiscount) {
        christmasDdayDiscount += ddayDiscount;
        discountAmount += ddayDiscount;
    }

    public boolean isPresentationDiscount() {
        if (amount >= 120000) {
            presentationDiscount += 25000;
            discountAmount += 25000;
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getWeekDayDiscount() {
        return weekDayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getChristmasDdayDiscount() {
        return christmasDdayDiscount;
    }

    public int getPresentationDiscount() {
        return presentationDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int[] getBenefits() {
        return benefits = new int[]{christmasDdayDiscount, weekDayDiscount, weekendDiscount, specialDiscount, presentationDiscount};
    }
}
