package christmas.controller;

import christmas.ChristmasPromotion;
import christmas.domain.Badge;
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
        int date = inputView.getVisitingDay();
        Map<String, Integer> orders = inputView.getOrders();
        outputView.readStartMessage(date);
        outputView.readOrderMenu(orders);
        christmasPromotion.setDiscount(date);
        christmasPromotion.setOrder(orders);
        int totalAmount = christmasPromotion.getTotalAmount();
        outputView.readTotalAmount(totalAmount);
        outputView.readPresentationEvent(christmasPromotion.isPresentationDiscount());
        christmasPromotion.setBenefits();
        outputView.readBenefits(christmasPromotion.getBenefits());
        int discountAmount = christmasPromotion.getDiscountAmount();
        outputView.readDiscountAmount(discountAmount);
        outputView.readPayAmount(christmasPromotion.getPayAmount());
        outputView.readBadge(christmasPromotion.getBadge(discountAmount));
    }
}
