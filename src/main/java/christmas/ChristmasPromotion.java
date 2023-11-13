package christmas;

import christmas.domain.Badge;
import christmas.domain.Calculator;
import christmas.domain.Discount;

import java.util.Map;

public class ChristmasPromotion {
    Discount discount;
    Map<String, Integer> order;
    Calculator calculator;
    int[] benefits;

    public ChristmasPromotion() {
        this.benefits = new int[5];
    }

    public void setDiscount(int date) {
        this.discount = new Discount(date);
    }

    public void setOrder(Map<String, Integer> order) {
        this.order = order;
        this.calculator = new Calculator(order);
    }

    public int getTotalAmount() {
        calculator.calculateAmount();
        return calculator.getAmount();
    }

    public boolean isPresentationDiscount() {
        return calculator.isPresentationDiscount();
    }

    public void setBenefits() {
        if (isOverEventApplyMoney()) {
            calculateChirstmasDiscount();
            calculateWeekDayDiscount();
            calculateWeekendDiscount();
            calculateSpecialDiscount();
        }
    }

    private void calculateSpecialDiscount() {
        if (discount.isSpecialDiscount()) {
            calculator.calculateSpecialDiscount();
        }
    }

    private void calculateWeekendDiscount() {
        if (discount.isWeekOrWeekend().equals("주말")) {
            calculator.calculateWeekendDiscount();
        }
    }

    private void calculateWeekDayDiscount() {
        if (discount.isWeekOrWeekend().equals("주중")) {
            calculator.calculateWeekDayDiscount();
        }
    }

    private void calculateChirstmasDiscount() {
        if (discount.isChristmasDiscount()) {
            calculator.calculateChristmasDdayDiscount(discount.calculateChristmasDiscount());
        }
    }
    private boolean isOverEventApplyMoney() {
        return calculator.getAmount() < 10000;
    }
    public int[] getBenefits() {
        benefits = calculator.getBenefits();
        return benefits;
    }

    public int getDiscountAmount() {
        return calculator.getDiscountAmount();
    }

    public int getPayAmount() {
        int payAmount = calculator.getAmount();
        for (int type = 0; type < benefits.length -1; type++) {
            payAmount -= benefits[type];
        }
        return payAmount;
    }

    public String getBadge(int discountAmount) {
        return Badge.findBadgeByAmount(discountAmount).getName();
    }
}
