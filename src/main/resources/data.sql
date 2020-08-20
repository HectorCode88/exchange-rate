DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS exchange;

CREATE TABLE currency (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code_currency VARCHAR(3) NOT NULL,
  description_currency VARCHAR(20) NOT NULL
);

CREATE TABLE exchange (
  id INT AUTO_INCREMENT PRIMARY KEY,
  code_origin_currency VARCHAR(3) NOT NULL,
  code_destination_currency VARCHAR(3) NOT NULL,
  exchange_rate DOUBLE NOT NULL
);

INSERT INTO currency (code_currency, description_currency) VALUES
('PEN', 'Soles'),
('DOL', 'Dólares'),
('EUR', 'Euros');

INSERT INTO exchange (code_origin_currency, code_destination_currency, exchange_rate) VALUES
('PEN', 'DOL', 0.28),
('DOL', 'PEN', 3.56),
('PEN', 'EUR', 0.24),
('EUR', 'PEN', 4.23);
