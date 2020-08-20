package pe.challenge.basic.backend.service;

import io.reactivex.Flowable;
import io.reactivex.Single;
import pe.challenge.basic.backend.model.CurrencyDto;
import pe.challenge.basic.backend.model.ExchangeDto;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;

public interface ExchangeRateService {

  Single<ExchangeRateResponse> changeCurrency(ExchangeRateRequest exchangeRateRequest);

  Flowable<CurrencyDto> listCurrency();

  Flowable<ExchangeDto> listExchange();

  Single<CurrencyDto> saveCurrency(CurrencyDto currencyDto);

  Single<ExchangeDto> saveExchange(ExchangeDto exchangeDto);
}
