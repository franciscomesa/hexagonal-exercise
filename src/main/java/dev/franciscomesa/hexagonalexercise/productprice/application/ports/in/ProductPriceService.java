package dev.franciscomesa.hexagonalexercise.productprice.application.ports.in;

import dev.franciscomesa.hexagonalexercise.productprice.domain.ProductPrice;

import java.util.Optional;

public interface ProductPriceService {
    Optional<ProductPrice> findAppliedPrice(FindProductCommand findProductCommand);
}