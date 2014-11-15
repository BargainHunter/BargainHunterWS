INSERT INTO company (company_name, country, city, address, address_no, zip) VALUES ('Masoutis', 'Greece', 'Athens', 'Venizelou', '35', '12345');

INSERT INTO store (address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Edessis', '17', 'Serres', 'Greece', 42.123456, 24.321654, 62123, 1);
INSERT INTO store (address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Komninon', '1', 'Thessaloniki', 'Greece', 42.1456, 24.1654, 62123, 1);

INSERT INTO offer (description, exp_date, price, start_date, title, store_id) VALUES ('2 Uperoxoi Giri me Cola', '2014-11-13', 10, '2014-11-20', '2 Giri + CocaCola', 1);
INSERT INTO offer (description, exp_date, price, start_date, title, store_id) VALUES ('4 Uperoxoi Giri me Cola', '2014-11-12', 10, '2014-11-19', '4 Giri + CocaCola', 1);
