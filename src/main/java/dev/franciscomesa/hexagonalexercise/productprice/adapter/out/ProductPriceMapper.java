package dev.franciscomesa.hexagonalexercise.productprice.adapter.out;

import dev.franciscomesa.hexagonalexercise.productprice.domain.model.ProductPrice;

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
