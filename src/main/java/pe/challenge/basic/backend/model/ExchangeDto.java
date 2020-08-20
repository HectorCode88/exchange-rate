package pe.challenge.basic.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exchange")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDto {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "code_origin_currency")
  private String codeOriginCurrency;

  @Column(name = "code_destination_currency")
  private String codeDestinationCurrency;

  @Column(name = "exchange_rate")
  private Double exchangeRate;

}
