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
public class ExchangeRateResponse {

    @JsonProperty("amount")
  	private String amount; //"monto" : "12.4",

    @JsonProperty("exchanged_amount")
    private String exchangedAmount; //"monto_con_tipo_de_cambio" : "43.4",

    @JsonProperty("origin_currency")
    private String originCurrency; //"moneda_origen" : "Soles",

    @JsonProperty("destination_currency")
    private String destinationCurrency; //"moneda_destino" : "Dolares",

    @JsonProperty("exchange_rate")
    private String exchangeRate; //"tipo_de_cambio" : "3.5"
}
