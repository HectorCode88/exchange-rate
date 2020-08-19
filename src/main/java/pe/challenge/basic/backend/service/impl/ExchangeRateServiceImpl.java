package pe.challenge.basic.backend.service.impl;

import io.reactivex.Single;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;
import pe.challenge.basic.backend.repository.ExchangeRateRepository;
import pe.challenge.basic.backend.service.ExchangeRateService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;

  @Override
  public Single<ExchangeRateResponse> changeCurrency(ExchangeRateRequest exchangeRateRequest) {

    return Single.fromCallable(() -> exchangeRateRepository.findById(1))
      .map(Optional::get)
      .map(currency -> ExchangeRateResponse.builder()
      .amount(exchangeRateRequest.getAmount())
      .originCurrency(exchangeRateRequest.getOriginCurrency())
      .destinationCurrency(exchangeRateRequest.getDestinationCurrency())
      .exchangedAmount(String.valueOf(Double.parseDouble(exchangeRateRequest.getAmount()) * currency.getExchangeRate()))
      .exchangeRate(String.valueOf(currency.getExchangeRate()))
      .build())
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "changeCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "changeCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "changeCurrency"));
  }
}
