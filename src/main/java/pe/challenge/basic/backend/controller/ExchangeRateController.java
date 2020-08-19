package pe.challenge.basic.backend.controller;

import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;
import pe.challenge.basic.backend.service.ExchangeRateService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange-rate/v1")
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  @PostMapping("/hello")
  public Single<ExchangeRateResponse> hello(@RequestBody ExchangeRateRequest exchangeRateRequest) {
    log.info("Starting {}.{} method", "ExchangeRateController", "hello");
    return exchangeRateService.changeCurrency(exchangeRateRequest)
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateController", "hello", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateController",
        "hello", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateController", "hello"));
  }
}
