package christmas.validation;

import christmas.domain.menu.Food;
import christmas.domain.menu.Menu;
import christmas.exception.InvalidOrderFormatException;
import christmas.exception.InvalidVisitingDayFormatException;

import java.util.*;
import java.util.stream.Collectors;

public class ValidateOrders {

    public void validate(String input) {
        String[] splitInput = input.split(",");
        validateOrderFormat(splitInput);
        validateExistMenu(splitInput);
        validateDuplicateMenu(splitInput);
        validateEmptyAmount(splitInput);
        validateNotOnlyDrinks(splitInput);
        validateMaxAmount(splitInput);
    }

    private void validateOrderFormat(String[] splitOrder) {
        List<String> orders = Arrays.stream(splitOrder)
                .filter(order -> order.contains("-"))
                .toList();
        if (orders.isEmpty() || orders.size() != splitOrder.length) {
            throw new InvalidOrderFormatException();
        }
    }

    private void validateExistMenu(String[] splitOrder) {
        Arrays.stream(splitOrder)
                .filter(menu -> {
                    if (Food.getMenusByName(menu.split("-")[0]).isPresent()) {
                        return true;
                    }
                    throw new InvalidOrderFormatException();
                });
    }

    private void validateDuplicateMenu(String[] splitOrder) {
        Deque<String> orders = new ArrayDeque<>();
        for (String order : splitOrder) {
            String menuName = order.split("-")[0];
            orders.add(menuName);
        }
        while (!orders.isEmpty()) {
            String removedOrder = orders.removeFirst();
            if (orders.contains(removedOrder)) {
                throw new InvalidOrderFormatException();
            }
        }
    }

    private void validateEmptyAmount(String[] splitOrder) {
        Deque<String> amounts = new ArrayDeque<>();
        for (String amount : splitOrder) {
            String number = amount.split("-")[1];
            amounts.add(number);
        }
        while (!amounts.isEmpty()) {
            String removedAmount = amounts.removeFirst();
            validateNumberFormat(removedAmount);
        }
    }

    private void validateNumberFormat(String input) {
        if (!input.matches("^[1-9]{1}$|1{1}[0-9]{1}$|2{1}0{1}$")) {
            throw new InvalidOrderFormatException();
        }
    }

    private void validateNotOnlyDrinks(String[] splitOrder) {
        long count = Arrays.stream(splitOrder)
                .filter(menu ->
                        Menu.isNotDrink(Food.getMenusByName(menu.split("-")[0]).get())
                )
                .count();
        if (count == 0) {
            throw new InvalidOrderFormatException();
        }
    }

    private void validateMaxAmount(String[] splitOrder) {
        int maxAmount = 20;
        for (String amount : splitOrder) {
            String number = amount.split("-")[1];
            maxAmount -= Integer.parseInt(number);
        }
        if (maxAmount < 0) {
            throw new InvalidOrderFormatException();
        }
    }
}
