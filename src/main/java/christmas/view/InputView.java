package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.ValidateOrders;
import christmas.validation.ValidateVisitingDay;

import java.util.LinkedHashMap;
import java.util.Map;

public class InputView {
    private static final String INPUT_VISITING_DAT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int getVisitingDay() {
        System.out.println(INPUT_VISITING_DAT_MESSAGE);
        ValidateVisitingDay validateVisitingDay = new ValidateVisitingDay();
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateVisitingDay.validate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }

    public Map<String, Integer> getOrders() {
        System.out.println(INPUT_ORDER_MENU_MESSAGE);
        ValidateOrders validateOrders = new ValidateOrders();
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateOrders.validate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return mapOrders(input.split(","));
    }

    private Map<String, Integer> mapOrders(String[] orders) {
        Map<String, Integer> mapOrders = new LinkedHashMap<>();
        for (String order : orders) {
            mapOrders.put(order.split("-")[0], Integer.parseInt(order.split("-")[1]));
        }
        return mapOrders;
    }
}
