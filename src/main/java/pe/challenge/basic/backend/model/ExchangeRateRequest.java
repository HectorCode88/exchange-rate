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
  private String amount; //"monto" : "12.4",

  @JsonProperty("origin_currency")
  private String originCurrency; //"moneda_origen" : "Soles",

  @JsonProperty("destination_currency")
  private String destinationCurrency;  //"moneda_destino" : "Dolares"
}
