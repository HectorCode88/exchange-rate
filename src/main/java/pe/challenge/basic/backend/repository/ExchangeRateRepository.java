package pe.challenge.basic.backend.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import pe.challenge.basic.backend.model.Currency;

public interface ExchangeRateRepository extends CrudRepository<Currency, Integer> {

  @Override
  Currency save(Currency currency);

  @Override
  Optional<Currency> findById(Integer id);

  @Override
  boolean existsById(Integer id);

}
