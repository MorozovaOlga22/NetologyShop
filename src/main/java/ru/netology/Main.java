package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Basket basket = fullBasket(scanner);
        printCheck(scanner, basket);
    }

    private static Basket fullBasket(Scanner scanner) {
        final Basket basket = new Basket();

        while (true) {
            printBasketHint();

            final String operation = scanner.nextLine();
            switch (operation) {
                case "+": {
                    final String code = getProductCode(scanner);
                    basket.addProduct(code);
                    break;
                }
                case "-": {
                    final String code = getProductCode(scanner);
                    basket.deleteProduct(code);
                    break;
                }
                default: {
                    return basket;
                }
            }
        }
    }

    private static void printBasketHint() {
        System.out.println("Введите одно из следующих значений:");
        System.out.println("+, чтобы добавить товар");
        System.out.println("-, чтобы удалить товар");
        System.out.println("любое другое значение, чтобы завершить покупки и перейти к оплате");
    }

    private static String getProductCode(Scanner scanner) {
        System.out.println("Введите код товара");
        System.out.println("Весь ассортимент магазина:");
        ShopUtils.printAllProducts();
        return scanner.nextLine();
    }

    private static void printCheck(Scanner scanner, Basket basket) {
        printCheckHint();

        final CheckCounterService checkCounterService;
        final String operation = scanner.nextLine();
        switch (operation) {
            case "1": {
                checkCounterService = new CashMachine();
                break;
            }
            case "2": {
                checkCounterService = new OnlineShoppingSystem();
                break;
            }
            default: {
                System.out.println("Покупки отменены");
                return;
            }
        }
        final int totalSum = checkCounterService.getTotalSum(basket);
        if (totalSum == 0) {
            System.out.println("Вы ничего не купили");
        } else {
            System.out.println("Общая сумма покупок: " + totalSum);
        }
    }

    private static void printCheckHint() {
        System.out.println("Где бы Вы хотели купить товары? Введите");
        System.out.println("1, если хотите купить товары в нашем магазине в Москве");
        System.out.println("2, если хотите заказать товары в интернет-магазине");
        System.out.println("любое другое значение, чтобы отменить покупки");
    }
}
