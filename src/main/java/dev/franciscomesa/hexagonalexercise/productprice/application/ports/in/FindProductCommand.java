package dev.franciscomesa.hexagonalexercise.productprice.application.ports.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindProductCommand {
    Long productId;
    Long brandId;
    LocalDateTime applicationDate;


}
