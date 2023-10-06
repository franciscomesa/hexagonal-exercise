package dev.franciscomesa.hexagonalexercise.productprice.infraestructure;

import dev.franciscomesa.hexagonalexercise.productprice.application.ports.out.ProductPriceEntity;
import dev.franciscomesa.hexagonalexercise.productprice.application.ports.out.ProductPriceRepositoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceRepository extends ProductPriceRepositoryInterface, JpaRepository<ProductPriceEntity, Long> {
    List<ProductPriceEntity> findByProductIdAndBrandId(Long productId, Long brandId);
}
