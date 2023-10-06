package dev.franciscomesa.hexagonalexercise;

import dev.franciscomesa.hexagonalexercise.productprice.domain.model.ProductPrice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductPriceTests {
    static List<ProductPrice> productPrices;


    @BeforeAll
    public static void fixturesProductPrice() {
        long lowerPriority = 0;
        long higherPriority = 1;
        ProductPrice productPrice1 = buildFixture(lowerPriority, "2024-01-06 00.00.00", "2024-12-31 23.59.59",1.00);
        ProductPrice productPrice2 = buildFixture(higherPriority, "2024-01-06 15.00.00", "2024-01-06 18.30.00",2.00);
        productPrices = new ArrayList<>();
        productPrices.add(productPrice1);
        productPrices.add(productPrice2);
    }


    @Test
    public void productPrice_return_a_value_if_applied_date_is_start_date() {
        Optional<ProductPrice> productPrice = ProductPrice
                .getAppliedProductPrice(productPrices, LocalDateTimeHelper.fromString("2024-01-06 00.01.00"));

        assertTrue(productPrice.isPresent());
    }

    @Test
    public void productPrice_return_a_value_if_applied_date_is_end_date() {
        Optional<ProductPrice> productPrice = ProductPrice
                .getAppliedProductPrice(productPrices, LocalDateTimeHelper.fromString("2024-12-31 23.59.59"));

        assertTrue(productPrice.isPresent());
    }

    @Test
    public void productPrice_return_a_value_if_applied_date_is_between_start_and_end_dates() {
        Optional<ProductPrice> productPrice = ProductPrice
                .getAppliedProductPrice(productPrices, LocalDateTimeHelper.fromString("2024-02-02 00.00.00"));

        assertTrue(productPrice.isPresent());
        assertEquals(productPrice.get().price, 1.0);
    }

    @Test
    public void productPrice_return_the_price_with_highest_priority_if_two_prices_in_applied_date() {
        Optional<ProductPrice> productPrice = ProductPrice
                .getAppliedProductPrice(productPrices, LocalDateTimeHelper.fromString("2024-01-06 17.00.00"));

        assertTrue(productPrice.isPresent());
        assertEquals(productPrice.get().price, 2.0);
    }

    private static ProductPrice buildFixture(long priority, String startDate, String endDate, double price) {
        long DEFAULT_PRODUCT = 1;
        long DEFAULT_BRAND = 1;
        long DEFAULT_PRICE_LIST = 1;

        return ProductPrice.builder(
                DEFAULT_PRODUCT,
                DEFAULT_BRAND,
                DEFAULT_PRICE_LIST,
                priority,
                LocalDateTimeHelper.fromString(startDate),
                LocalDateTimeHelper.fromString(endDate),
                price);
    }
}
