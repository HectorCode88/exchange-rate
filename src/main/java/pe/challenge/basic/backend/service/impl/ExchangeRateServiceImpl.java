package pe.challenge.basic.backend.service.impl;

import io.reactivex.Flowable;
import io.reactivex.Single;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import pe.challenge.basic.backend.model.CurrencyDto;
import pe.challenge.basic.backend.model.ExchangeDto;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;
import pe.challenge.basic.backend.repository.CurrencyRepository;
import pe.challenge.basic.backend.repository.ExchangeRepository;
import pe.challenge.basic.backend.service.ExchangeRateService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

  private final ExchangeRepository exchangeRepository;

  private final CurrencyRepository currencyRepository;

  @Override
  public Single<ExchangeRateResponse> changeCurrency(ExchangeRateRequest request) {

    return Single.fromCallable(() -> exchangeRepository
      .findByCodeOriginCurrencyAndCodeDestinationCurrency(request.getOriginCurrencyCode(),
        request.getDestinationCurrencyCode()))
      .map(optionaDto -> optionaDto.orElseThrow(() ->
        new NotFoundException("El código de moneda de origen no existe.")))
      .map(exchangeDto -> Pair.of(exchangeDto,
        request.getAmount() * exchangeDto.getExchangeRate()))
      .map(pair -> ExchangeRateResponse.builder()
        .exchangeRate(pair.getFirst().getExchangeRate())
        .destinationCurrency(currencyRepository
          .findByCode(request.getDestinationCurrencyCode()).get().getDescription())
        .exchangedAmount(pair.getSecond())
        .originCurrency(currencyRepository
          .findByCode(request.getOriginCurrencyCode()).get().getDescription())
        .amount(request.getAmount())
        .build())
      .onErrorReturn(e -> ExchangeRateResponse.builder().errorMessage(e.getMessage()).build())
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "changeCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "changeCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "changeCurrency"));
  }

  @Override
  public Flowable<CurrencyDto> listCurrency() {
    return Flowable.fromIterable(currencyRepository.findAll())
      .doOnComplete(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "listCurrency"))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "listCurrency", throwable.getMessage()));
  }

  @Override
  public Flowable<ExchangeDto> listExchange() {
    return Flowable.fromIterable(exchangeRepository.findAll())
      .doOnComplete(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "listExchange"))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "listExchange", throwable.getMessage()));
  }

  @Override
  public Single<CurrencyDto> saveCurrency(CurrencyDto currencyDto) {
    log.info(currencyDto.toString());
    return Single.fromCallable(() -> currencyRepository.save(currencyDto))
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "saveCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "saveCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveCurrency"));
  }

  @Override
  public Single<ExchangeDto> saveExchange(ExchangeDto exchangeDto) {
    return Single.fromCallable(() -> exchangeRepository.save(exchangeDto))
      .doOnSuccess(s -> log.info("Success {}.{} method - {}", "ExchangeRateServiceImpl", "saveCurrency", s))
      .doOnError(throwable -> log.info("Error {}.{} method, with error {}", "ExchangeRateServiceImpl",
        "saveCurrency", throwable.getMessage()))
      .doOnTerminate(() -> log.info("Terminate {}.{} method", "ExchangeRateServiceImpl", "saveCurrency"));
  }

}
