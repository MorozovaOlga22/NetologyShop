package ru.netology;

import ru.netology.products.Product;

public class CashMachine implements CheckCounterService {
    @Override
    public int getTotalSum(Basket basket) {
        return basket.getProductsInBasket().entrySet().stream().mapToInt(entry -> {
            final String code = entry.getKey();
            final Product product = ShopUtils.getProductByCode(code);
            final int count = entry.getValue();
            return product.getPrice() * count;
        }).sum();
    }
}
