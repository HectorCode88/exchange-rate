DROP TABLE IF EXISTS currency;

CREATE TABLE currency (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  exchange_rate DOUBLE NOT NULL
);

INSERT INTO currency (exchange_rate) VALUES (4.9);