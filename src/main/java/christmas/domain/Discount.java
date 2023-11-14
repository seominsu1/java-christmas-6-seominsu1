package christmas.domain;

public class Discount {
    private final int christmasDiscountRate = 100;
    private final int christmasDiscountStart = 1000;
    private int date;

    public Discount(int date) {
        this.date = date;
    }

    public Boolean isChristmasDiscount() {
        return date <= 25;
    }

    public int calculateChristmasDiscount() {
        return (date - 1) * christmasDiscountRate + christmasDiscountStart;
    }

    public String isWeekOrWeekend() {
        if (December.findDiscountType(date).isPresent()) {
            return December.findDiscountType(date).get().getType();
        }
        return null;
    }

    public Boolean isSpecialDiscount() {
        return StarDay.findSpecialDiscountDay(date).isPresent();
    }
}
