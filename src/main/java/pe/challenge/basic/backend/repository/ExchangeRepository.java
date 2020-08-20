package pe.challenge.basic.backend.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pe.challenge.basic.backend.model.CurrencyDto;
import pe.challenge.basic.backend.model.ExchangeDto;

public interface ExchangeRepository extends CrudRepository<ExchangeDto, Integer> {

  Optional<ExchangeDto> findByCodeOriginCurrencyAndCodeDestinationCurrency(String origin,
                                                                        String destination);

  @Override
  boolean existsById(Integer id);

  @Override
  ExchangeDto save(ExchangeDto exchangeDto);

  @Override
  Iterable<ExchangeDto> findAll();
}
