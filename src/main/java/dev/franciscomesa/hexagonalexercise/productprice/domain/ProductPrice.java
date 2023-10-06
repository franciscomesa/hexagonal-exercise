package dev.franciscomesa.hexagonalexercise.productprice.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ProductPrice {
    final public Long productId;
    final public Long brandId;
    final public Long priceList;
    @Getter
    final public Long priority;
    final public LocalDateTime startDate;
    final public LocalDateTime endDate;
    final public Double price;

    private ProductPrice(Long productId, Long brandId, Long priceList, Long priority, LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public static ProductPrice builder(Long productId, Long brandId, Long priceList, Long priority, LocalDateTime startDate, LocalDateTime endDate, Double price) {
        return new ProductPrice(
            productId,
            brandId,
            priceList,
            priority,
            startDate,
            endDate,
            price
        );
    }

    public static Optional<ProductPrice> getAppliedProductPrice(List<ProductPrice> productPrices, LocalDateTime applicationDate) {
        return productPrices.stream()
                .filter(applicationDateBetweenStartAndEndDates(applicationDate)                )
                .max(Comparator.comparing(ProductPrice::getPriority));

    }

    private static Predicate<ProductPrice> applicationDateBetweenStartAndEndDates(LocalDateTime applicationDate) {
        return price -> price.startDate.isBefore(applicationDate) && price.endDate.isAfter(applicationDate)
                || price.startDate.isEqual(applicationDate) || price.endDate.isEqual(applicationDate);
    }

}
