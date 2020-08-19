package pe.challenge.basic.backend.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.reactivex.observers.TestObserver;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.challenge.basic.backend.model.Currency;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;
import pe.challenge.basic.backend.repository.ExchangeRateRepository;

class ExchangeRateServiceImplTest {

  @InjectMocks
  private ExchangeRateServiceImpl exchangeRateService;

  @Mock
  private ExchangeRateRepository exchangeRateRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void changeCurrency() {
    Currency mockCurrency = Currency.builder()
      .id(1)
      .exchangeRate(3.5)
      .build();
    when(exchangeRateRepository.findById(any())).thenReturn(Optional.of(mockCurrency));

    ExchangeRateRequest mockRequest = ExchangeRateRequest.builder()
      .amount("777")
      .originCurrency("Dolares")
      .destinationCurrency("Soles")
      .build();

    ExchangeRateResponse expectedResponse = ExchangeRateResponse.builder()
      .originCurrency("Dolares")
      .destinationCurrency("Soles")
      .exchangedAmount("2719.5")
      .amount("777")
      .exchangeRate("3.5")
      .build();

    TestObserver<ExchangeRateResponse> test = exchangeRateService.changeCurrency(mockRequest).test();

    test.awaitTerminalEvent();
    test.onSuccess(expectedResponse);
  }
}