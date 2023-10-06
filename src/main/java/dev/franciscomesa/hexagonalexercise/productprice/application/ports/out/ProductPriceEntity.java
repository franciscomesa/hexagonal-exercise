package dev.franciscomesa.hexagonalexercise.productprice.application.ports.out;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
public class ProductPriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long productId;
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priority;
    private Long priceList;
    private Double price;
    private String currency;

    private ProductPriceEntity(Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long priority, Double price, String currency) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public ProductPriceEntity() {
    }

    public static ProductPriceEntity createPriceWithStringDates(Long productId, Long brandId, String startDate, String endDate, Long priceList, Long priority, Double price, String currency) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
        return createPrice(productId, brandId, LocalDateTime.parse(startDate, dateFormatter), LocalDateTime.parse(endDate, dateFormatter), priceList, priority, price, currency);
    }

    public static ProductPriceEntity createPrice(Long productId, Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList, Long priority, Double price, String currency) {
        return new ProductPriceEntity(productId, brandId, startDate, endDate, priceList, priority, price, currency);
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", productId=" + productId +
                ", brandId=" + brandId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
