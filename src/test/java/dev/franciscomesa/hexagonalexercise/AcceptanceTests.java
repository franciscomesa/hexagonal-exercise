package dev.franciscomesa.hexagonalexercise;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTests {
    long BRAND_ID = 1;
    long PRODUCT_ID = 35455;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void request_at_TenOClock_At_day14_from_product_34544_should_returnX () throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("productId", String.valueOf(this.PRODUCT_ID))
                        .param("brandId", String.valueOf(this.BRAND_ID))
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    void request_at_SixteenOClock_At_day14_from_product_34544_should_returnX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("productId", String.valueOf(this.PRODUCT_ID))
                        .param("brandId", String.valueOf(this.BRAND_ID))
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
    }

    @Test
    void request_at_TwentyOneOClock_At_day14_from_product_34544_should_returnX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("productId", String.valueOf(this.PRODUCT_ID))
                        .param("brandId", String.valueOf(this.BRAND_ID))
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }

    @Test
    void request_at_TenOClock_At_day15_from_product_34544_should_returnX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("productId", String.valueOf(this.PRODUCT_ID))
                        .param("brandId", String.valueOf(this.BRAND_ID))
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50));
    }

    @Test
    void request_at_TwentyOneOClock_At_day15_from_product_34544_should_returnX() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api")
                        .param("productId", String.valueOf(this.PRODUCT_ID))
                        .param("brandId", String.valueOf(this.BRAND_ID))
                        .param("applicationDate", "2020-06-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(7)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(35455))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
    }
}
