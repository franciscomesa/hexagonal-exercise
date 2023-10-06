package dev.franciscomesa.hexagonalexercise.productprice.application.ports.in;

import dev.franciscomesa.hexagonalexercise.productprice.domain.ProductPrice;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface FindPriceByBrandProductAndDatePort {
    public ResponseEntity<ProductPrice> getPrices(LocalDateTime applicationDate, Long productId, Long brandId) ;
}
