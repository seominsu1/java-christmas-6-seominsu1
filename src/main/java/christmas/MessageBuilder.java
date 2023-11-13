package christmas;

import java.text.DecimalFormat;
import java.util.Map;

public class MessageBuilder {

    private static final String MONTH = "12월";
    private static final String DATE = "일";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_AMOUNT_MESSAGE = "<할인 전 총주문 금액>";
    private static final String PRESENTATION_EVENT_MESSAGE = "<증정 메뉴>";
    private static final String BENEFITS_MESSAGE = "<혜택 내역>";
    private static final String DISCOUNT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String PAY_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String AMOUNT = "개";
    private static final String MONEY = "원";
    private static final String CHAMPAGNE = "샴페인 1개";
    private static final String EMPTY = "없음";
    private static final String[] BENEFITS = {"크리스마스 디데이 할인: ", "평일 할인: ", "주말 할인: ", "특별 할인: ", "증정 이벤트: "};

    private DecimalFormat formatter;

    public MessageBuilder() {
        this.formatter = new DecimalFormat("###,###");
    }

    public String buildDateMessage(int date) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MONTH).append(" ").append(date).append(DATE);
        return stringBuilder.toString();
    }

    public String buildOrderMenuMessage(Map<String, Integer> orders) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append(ORDER_MENU_MESSAGE);
        orders.forEach((key, value) -> stringBuilder.append("\n")
                .append(key)
                .append(" ")
                .append(value)
                .append(AMOUNT));
        return stringBuilder.toString();
    }

    public String buildTotalAmountMessage(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n")
                .append(TOTAL_AMOUNT_MESSAGE)
                .append("\n")
                .append(buildByMoneyFormat(amount))
                .append(MONEY);
        return stringBuilder.toString();
    }

    private String buildByMoneyFormat(int money) {
        return formatter.format(money);
    }

    public String buildPresentationEventMessage(boolean isPresentationDiscount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(PRESENTATION_EVENT_MESSAGE);
        if (isPresentationDiscount) {
            stringBuilder.append("\n")
                    .append(CHAMPAGNE);
            return stringBuilder.toString();
        }
        stringBuilder.append("\n")
                .append(EMPTY);
        return stringBuilder.toString();
    }

    public String buildBenefitsMessage(int[] benefits) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(BENEFITS_MESSAGE).append("\n");
        if (isEmptyBenefits(benefits)) {
            stringBuilder.append(EMPTY);
            return stringBuilder.toString();
        }
        buildBenefits(benefits, stringBuilder);
        return stringBuilder.toString();
    }

    private void buildBenefits(int[] benefits, StringBuilder stringBuilder) {
        for (int index = 0; index < benefits.length; index++) {
            if (benefits[index] > 0) {
                stringBuilder.append(BENEFITS[index])
                        .append("-")
                        .append(formatter.format(benefits[index]))
                        .append(MONEY);
            }
        }
    }

    private boolean isEmptyBenefits(int[] benefits) {
        int benefitAmount = 0;
        for (int benefit : benefits) {
            benefitAmount += benefit;
        }
        return benefitAmount == 0;
    }
    public String buildDiscountAmountMessage(int discountAmount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(DISCOUNT_AMOUNT_MESSAGE).append("\n");
        if (discountAmount == 0) {
            return stringBuilder.append(EMPTY).toString();
        }
        stringBuilder.append("-")
                .append(formatter.format(discountAmount))
                .append(MONEY);
        return stringBuilder.toString();
    }

    public String buildPayAmountMessage(int payAmount) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n")
                .append(PAY_AMOUNT_MESSAGE)
                .append("\n")
                .append(formatter.format(payAmount))
                .append(MONEY);
        return stringBuilder.toString();
    }
    public String buildBadgeMessage(String badge) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n")
                .append(BADGE_MESSAGE)
                .append("\n")
                .append(badge);
        return stringBuilder.toString();
    }
}
