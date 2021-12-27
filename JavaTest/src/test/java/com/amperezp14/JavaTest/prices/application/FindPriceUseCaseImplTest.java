package com.amperezp14.JavaTest.prices.application;

import com.amperezp14.JavaTest.prices.domain.Price;
import com.amperezp14.JavaTest.prices.infraestructure.repository.IPriceRepository;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
class FindPriceUseCaseImplTest {

    @Mock
    private IPriceRepository priceRepository;

    @InjectMocks
    private FindPriceUseCaseImpl findPriceUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findPrice() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020,
                Month.JULY, 14, 19, 30, 40);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020,
                Month.AUGUST, 14, 19, 30, 40);
        LocalDateTime localDateTimeApplication = LocalDateTime.of(2020,
                Month.JULY, 21, 19, 30, 40);

        PriceResponse priceResponse = PriceResponse.builder().
                product_id(1).
                brand_id(1).
                price_list(1).
                price(20.45).
                start_date(localDateTimeStart).
                end_date(localDateTimeEnd).build();
        PriceRequest priceRequest = PriceRequest.builder().
                                    product_id(1).
                                    brand_id(1).
                                    application_date(localDateTimeApplication).build();
        Price price = Price.builder().
                id(1).
                product_id(1).
                brand_id(1).
                price_list(1).
                price(20.45).
                priority(1).
                curr("EUR").
                start_date(localDateTimeStart).
                end_date(localDateTimeEnd).build();

        Mockito.when(priceRepository.findAll()).thenReturn(Arrays.asList(price));
        assertNotNull(findPriceUseCase.findPrice(priceRequest));

    }
}