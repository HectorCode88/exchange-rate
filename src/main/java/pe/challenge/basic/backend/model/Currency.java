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
@Table(name = "currency")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Column(name = "exchange_rate")
  private Double exchangeRate; //exchange_rate
}
