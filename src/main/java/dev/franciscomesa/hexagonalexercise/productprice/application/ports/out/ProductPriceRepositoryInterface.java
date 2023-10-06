package dev.franciscomesa.hexagonalexercise.productprice.application.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductPriceRepositoryInterface {
    List<ProductPriceEntity> findByProductIdAndBrandId(Long productId, Long brandId);
}



