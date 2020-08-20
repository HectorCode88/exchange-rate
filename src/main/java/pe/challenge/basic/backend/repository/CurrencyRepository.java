package pe.challenge.basic.backend.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pe.challenge.basic.backend.model.CurrencyDto;

public interface CurrencyRepository extends CrudRepository<CurrencyDto, Integer> {

  Optional<CurrencyDto> findByCode(String code);

  @Override
  CurrencyDto save(CurrencyDto currencyDto);

  @Override
  Iterable<CurrencyDto> findAll();
}
