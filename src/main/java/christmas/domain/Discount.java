package christmas.domain;

public class Discount {
    private int date;

    public Discount(int date) {
        this.date = date;
    }

    public Boolean isChristmasDiscount() {
        return date <= 25;
    }

    public int calculateChristmasDiscount() {
        return date - 1;
    }

    public String isWeekOrWeekend() {
        if (December.findDiscountType(date).isPresent()) {
            return December.findDiscountType(date).get().getType();
        }return null;
    }

    public Boolean isSpecialDiscount() {
        return StarDay.findSpecialDiscountDay(date).isPresent();
    }
}
