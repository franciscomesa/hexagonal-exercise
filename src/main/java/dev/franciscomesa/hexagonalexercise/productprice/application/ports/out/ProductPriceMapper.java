package dev.franciscomesa.hexagonalexercise.productprice.application.ports.out;

import dev.franciscomesa.hexagonalexercise.productprice.domain.ProductPrice;

public class ProductPriceMapper {
    public static ProductPrice entityToDomain(ProductPriceEntity productPrice) {
        return ProductPrice.builder(
                productPrice.getProductId(),
                productPrice.getBrandId(),
                productPrice.getPriceList(),
                productPrice.getPriority(),
                productPrice.getStartDate(),
                productPrice.getEndDate(),
                productPrice.getPrice()
        );
    }
}
