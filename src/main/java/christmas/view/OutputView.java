package christmas.view;

import christmas.MessageBuilder;

import java.util.Map;

public class OutputView {
    private static final String PROMOTION_START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String OUTPUT_START_MESSAGE = "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private MessageBuilder stringBuilder;

    public OutputView() {
        this.stringBuilder = new MessageBuilder();
    }

    public void readPromotionStartMessage() {
        System.out.println(PROMOTION_START_MESSAGE);
    }

    public void readStartMessage(int day) {
        String dateMessage = stringBuilder.buildDateMessage(day);
        System.out.println(dateMessage + OUTPUT_START_MESSAGE);
    }

    public void readOrderMenu(Map<String, Integer> order) {
        String orderMenuMessage = stringBuilder.buildOrderMenuMessage(order);
        System.out.println(orderMenuMessage);
    }

    public void readTotalAmount(int amount) {
        String totalAmountMessage = stringBuilder.buildTotalAmountMessage(amount);
        System.out.println(totalAmountMessage);
    }

    public void readPresentationEvent(boolean isPresentationDiscount) {
        String presentationEventMessage = stringBuilder.buildPresentationEventMessage(isPresentationDiscount);
        System.out.println(presentationEventMessage);
    }

    public void readBenefits(int[] benefits) {
        String benefitsMessage = stringBuilder.buildBenefitsMessage(benefits);
        System.out.println(benefitsMessage);
    }


    public void readDiscountAmount(int discountAmount) {
        String discountAmountMessage = stringBuilder.buildDiscountAmountMessage(discountAmount);
        System.out.println(discountAmountMessage);
    }

    public void readPayAmount(int payAmount) {
        String payAmountMessage = stringBuilder.buildPayAmountMessage(payAmount);
        System.out.println(payAmountMessage);
    }

    public void readBadge(String badge) {
        String badgeMessage = stringBuilder.buildBadgeMessage(badge);
        System.out.println(badgeMessage);
    }
}
