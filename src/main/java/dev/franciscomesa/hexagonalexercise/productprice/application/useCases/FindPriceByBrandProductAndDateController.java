package dev.franciscomesa.hexagonalexercise.productprice.application.useCases;

import dev.franciscomesa.hexagonalexercise.productprice.application.ports.in.FindPriceByBrandProductAndDatePort;
import dev.franciscomesa.hexagonalexercise.productprice.application.ports.in.FindProductCommand;
import dev.franciscomesa.hexagonalexercise.productprice.application.services.ProductPriceServiceImpl;
import dev.franciscomesa.hexagonalexercise.productprice.domain.ProductPrice;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FindPriceByBrandProductAndDateController implements FindPriceByBrandProductAndDatePort {
    private final ProductPriceServiceImpl productPriceService;

    public FindPriceByBrandProductAndDateController(ProductPriceServiceImpl productPriceService) {
        this.productPriceService = productPriceService;
    }

    @GetMapping
    public ResponseEntity<ProductPrice> getPrices(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {
        FindProductCommand findProductCommand = new FindProductCommand(productId, brandId, applicationDate);

        Optional<ProductPrice> price = productPriceService.findAppliedPrice(findProductCommand);
        if (price.isPresent()) {
            return ResponseEntity.ok(price.get());
        }
        return (ResponseEntity<ProductPrice>) ResponseEntity.notFound();
    }
}


