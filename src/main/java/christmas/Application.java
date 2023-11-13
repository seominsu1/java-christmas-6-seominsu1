package christmas;

import christmas.controller.ChristmasController;
import christmas.domain.Badge;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ChristmasController christmasController = new ChristmasController();
        christmasController.start();
    }
}
