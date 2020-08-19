package pe.challenge.basic.backend.service;

import io.reactivex.Single;
import pe.challenge.basic.backend.model.ExchangeRateRequest;
import pe.challenge.basic.backend.model.ExchangeRateResponse;

public interface ExchangeRateService {

  Single<ExchangeRateResponse> changeCurrency(ExchangeRateRequest exchangeRateRequest);
}
