package dev.franciscomesa.hexagonalexercise;

import dev.franciscomesa.hexagonalexercise.productprice.adapter.out.ProductPriceEntity;
import dev.franciscomesa.hexagonalexercise.productprice.domain.repository.ProductPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Fixtures implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(Fixtures.class);
    private final ProductPriceRepository repository;

    public Fixtures(ProductPriceRepository productPriceRepository) {
        this.repository = productPriceRepository;
    }


    @Override
    public void afterPropertiesSet() {
        long BRAND_ID = 1;
        long PRODUCT_ID = 35455;
        String CURRENCY = "EUR";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");

        repository.save(ProductPriceEntity.createPrice(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-14 00.00.00", dateFormatter), LocalDateTime.parse("2020-12-31 23.59.59", dateFormatter), 1L, 0L, 35.50, CURRENCY));
        repository.save(ProductPriceEntity.createPrice(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-14 15.00.00", dateFormatter), LocalDateTime.parse("2020-06-14 18.30.00", dateFormatter), 2L, 1L, 25.45, CURRENCY));
        repository.save(ProductPriceEntity.createPrice(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-15 00.00.00", dateFormatter), LocalDateTime.parse("2020-06-15 11.00.00", dateFormatter), 3L, 1L, 30.50, CURRENCY));
        repository.save(ProductPriceEntity.createPrice(PRODUCT_ID, BRAND_ID, LocalDateTime.parse("2020-06-15 16.00.00", dateFormatter), LocalDateTime.parse("2020-12-31 23.59.59", dateFormatter), 4L, 1L, 38.95, CURRENCY));

        showAllProductsPricesAtRepository();
    }

    private void showAllProductsPricesAtRepository() {
        for (ProductPriceEntity price : this.repository.findAll()) {
            log.info("The price at repository is: " + price.toString());
        }
    }

}



