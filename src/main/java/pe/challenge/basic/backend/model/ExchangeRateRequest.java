package pe.challenge.basic.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateRequest {

  @JsonProperty("amount")
  private Double amount; //12.3

  @JsonProperty("origin_currency_code")
  private String originCurrencyCode; //PEN

  @JsonProperty("destination_currency_code")
  private String destinationCurrencyCode; //DOL

}
