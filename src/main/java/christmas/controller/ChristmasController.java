package christmas.controller;

import christmas.ChristmasPromotion;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasController {

    InputView inputView;
    OutputView outputView;
    ChristmasPromotion christmasPromotion;

    public ChristmasController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.christmasPromotion = new ChristmasPromotion();
    }

    public void start() {
        outputView.readPromotionStartMessage();
        int date = getVisitingDay();
        Map<String, Integer> orders = getOrders();
        readOrderMenu(date, orders);
        setEventConditions(date, orders);
        readTotalAmount();
        readPresentationEvent();
        readBenefits();
        int discountAmount = getDiscountAmount();
        readDiscountAmount(discountAmount);
        getReadPayAmount();
        readBadge(discountAmount);
    }

    private void readBadge(int discountAmount) {
        outputView.readBadge(christmasPromotion.getBadge(discountAmount));
    }

    private void getReadPayAmount() {
        outputView.readPayAmount(christmasPromotion.getPayAmount());
    }

    private void readDiscountAmount(int discountAmount) {
        outputView.readDiscountAmount(discountAmount);
    }

    private int getDiscountAmount() {
        return christmasPromotion.getDiscountAmount();
    }

    private void readBenefits() {
        christmasPromotion.setBenefits();
        outputView.readBenefits(christmasPromotion.getBenefits());
    }

    private void readPresentationEvent() {
        outputView.readPresentationEvent(christmasPromotion.isPresentationDiscount());
    }

    private void readTotalAmount() {
        int totalAmount = christmasPromotion.getTotalAmount();
        outputView.readTotalAmount(totalAmount);
    }

    private void setEventConditions(int date, Map<String, Integer> orders) {
        christmasPromotion.setDiscount(date);
        christmasPromotion.setOrder(orders);
    }

    private void readOrderMenu(int date, Map<String, Integer> orders) {
        outputView.readStartMessage(date);
        outputView.readOrderMenu(orders);
    }

    private Map<String, Integer> getOrders() {
        return inputView.getOrders();
    }

    private int getVisitingDay() {
        return inputView.getVisitingDay();
    }
}
