package ru.netology;

import ru.netology.products.Clothes;
import ru.netology.products.Product;

public class OnlineShoppingSystem implements CheckCounterService, MailDeliveryService {
    private final static double CLOTHES_FRACTION_OF_STARTING_PRICE = 0.9;
    private final static int DELIVERY_COST = 1_000;

    @Override
    public int getTotalSum(Basket basket) {
        final int productsSum = basket.getProductsInBasket().entrySet().stream().mapToInt(entry -> {
            final String code = entry.getKey();
            final Product product = ShopUtils.getProductByCode(code);
            final int count = entry.getValue();
            final int finalPrice;
            if (product instanceof Clothes) {
                finalPrice = (int) (product.getPrice() * CLOTHES_FRACTION_OF_STARTING_PRICE);
            } else {
                finalPrice = product.getPrice();
            }
            return finalPrice * count;
        }).sum();

        return productsSum == 0 ? 0 : productsSum + DELIVERY_COST;
    }

    @Override
    public void sendMails() {
        //Здесь должна быть какая-то более сложная логика
        ShopUtils.printAllProducts();
    }
}
