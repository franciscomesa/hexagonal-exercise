package dev.franciscomesa.hexagonalexercise.productprice.application.services;

import dev.franciscomesa.hexagonalexercise.productprice.application.ports.in.FindProductCommand;
import dev.franciscomesa.hexagonalexercise.productprice.application.ports.out.ProductPriceMapper;
import dev.franciscomesa.hexagonalexercise.productprice.domain.ProductPrice;
import dev.franciscomesa.hexagonalexercise.productprice.application.ports.out.ProductPriceEntity;
import dev.franciscomesa.hexagonalexercise.productprice.infraestructure.ProductPriceRepository;
import dev.franciscomesa.hexagonalexercise.productprice.application.ports.in.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {
    @Autowired
    private final ProductPriceRepository priceRepository;

    public ProductPriceServiceImpl(ProductPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<ProductPrice> findAppliedPrice(FindProductCommand findProductCommand) {
        List<ProductPriceEntity> productPriceEntityList = priceRepository.findByProductIdAndBrandId(
                findProductCommand.getProductId(),
                findProductCommand.getBrandId()
        );
        if (productPriceEntityList == null || productPriceEntityList.isEmpty()) {
            return Optional.empty();
        }
        List<ProductPrice> productPriceList = productPriceEntityList
                .stream()
                .map(ProductPriceMapper::entityToDomain)
                .toList();

        return ProductPrice.getAppliedProductPrice(productPriceList, findProductCommand.getApplicationDate());
    }

}


