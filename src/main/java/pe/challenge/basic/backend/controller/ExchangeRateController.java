package pe.challenge.basic.backend.controller;

import io.reactivex.Flowable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.challenge.basic.backend.model.CurrencyDto;
import pe.challenge.basic.backend.model.ExchangeDto;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;
import pe.challenge.basic.backend.service.ExchangeRateService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rate/v1/currency")
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  @PostMapping(value = "/change",
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public Single<ExchangeRateResponse> changeCurrency(@RequestBody ExchangeRateRequest exchangeRateRequest) {
    log.info("Starting {}.{} method", "ExchangeRateController", "changeCurrency");
    return exchangeRateService.changeCurrency(exchangeRateRequest)
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "changeCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "changeCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "changeCurrency"));
  }

  @GetMapping(
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flowable<CurrencyDto> listCurrency() {
    log.info("Starting {}.{} method", "ExchangeRateController", "listCurrency");
    return exchangeRateService.listCurrency()
      .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController",
      "listCurrency"))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "listCurrency", throwable.getMessage()));
  }

  @PostMapping(
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public Single<CurrencyDto> saveCurrency(@RequestBody CurrencyDto currencyDto) {
    log.info("Starting {}.{} method", "ExchangeRateController", "saveCurrency");
    return exchangeRateService.saveCurrency(currencyDto)
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "saveCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "saveCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "saveCurrency"));
  }


  @PatchMapping(
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public Single<CurrencyDto> updateCurrency(@RequestBody CurrencyDto currencyDto) {
    log.info("Starting {}.{} method", "ExchangeRateController", "updateCurrency");
    return exchangeRateService.saveCurrency(currencyDto)
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "updateCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "updateCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "updateCurrency"));
  }

  @GetMapping(value = "/exchange",
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flowable<ExchangeDto> listExchange() {
    log.info("Starting {}.{} method", "ExchangeRateController", "listExchange");
    return exchangeRateService.listExchange()
      .doOnComplete(() -> log.info("Success {}.{} method - {}", "ExchangeRateController",
        "listExchange"))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "listExchange", throwable.getMessage()));
  }

  @PatchMapping(value = "/exchange",
    produces = MediaType.APPLICATION_STREAM_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
  public Single<ExchangeDto> updateExchange(@RequestBody ExchangeDto exchangeDto) {
    log.info("Starting {}.{} method", "ExchangeRateController", "updateExchange");
    return exchangeRateService.saveExchange(exchangeDto)
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "updateExchange", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "updateExchange", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "updateExchange"));
  }
}
