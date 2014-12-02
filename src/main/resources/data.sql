INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Diamantis Masoutis AE', 'Greece', 'Thessaloniki', '_', '_', '57001');
INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Gatidis S.A', 'Greece', 'Serres', '_', '_', '62122');
INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Public', 'Greece', 'Athens', '_', '_', '16674');


INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Masoutis', 'Miaouli', '4', 'Serres', 'Greece', 41.089438, 23.544533, 62121, 1);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Masoutis', 'Patriarxou Grigoriou Z', '10', 'Serres', 'Greece', 41.086757, 23.545687, 62125, 1);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Gatidis', 'Karaiskaki', '19', 'Serres', 'Greece', 41.0908408, 23.5414613, 62100, 2);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Gatidis', 'Konstantinoupolews', '4', 'Serres', 'Greece', 41.090320, 23.551747, 62122, 2);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Gatidis', 'Vasileiou', '14', 'Serres', 'Greece', 41.0908245, 23.5479897, 62121, 2);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Public', 'Tsalopoulou', '9', 'Serres', 'Greece', 41.089644,23.550258, 62122, 3);
INSERT INTO STORE (store_name, address, address_no, city, country, latitude, longitude, zip, company_id) VALUES ('Public', 'Tsimiski', '24', 'Thessaloniki', 'Greece', 40.6336695,22.9410913, 54624, 3);


INSERT INTO SUBCATEGORY (description) VALUES ('Sweets');
INSERT INTO SUBCATEGORY (description) VALUES ('Snacks');
INSERT INTO SUBCATEGORY (description) VALUES ('Bread');
INSERT INTO SUBCATEGORY (description) VALUES ('Laptop');
INSERT INTO SUBCATEGORY (description) VALUES ('Tablet');

INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Mini κρουασάν βουτύρου ALFA', '2014-11-13', 4.64, '2015-3-19', 'Mini κρουασάν βουτύρου ALFA 1+1 ΔΩΡΟ!', 1, 1);
INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Chips Lays Xtra waves', '2014-11-13', 0.83, '2015-3-19', 'Chips Lays Xtra waves 23% φθηνότερα!', 1, 2);
INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Ψωμί Πολύσπορο', '2014-11-13', 0.80, '2015-3-19', 'Έκπτωση στο πολύσπορο -0,10 λεπτά!', 2, 3);
INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Προφιτερόλ', '2014-11-13', 1.20, '2015-3-19', 'Προφιτερόλ -0,30 λεπτά!', 2, 1);
INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Laptop Dell Inspiron Q15R', '2014-11-13', 365, '2015-3-19', 'Λάπτοπ Dell Inspiron Q15R - Laptop - Core i3-2310M 2.10 GHz - 15.6" LED 20% έκπτωση!', 3, 4);
INSERT INTO OFFER (description, exp_date, price, start_date, title, company_id, subcategory_id) VALUES ('Asus MeMo Pad 7 ME70C', '2014-11-13', 100, '2015-3-19', 'Asus MeMo Pad 7 ME70C - Tablet 7" -30 ευρω έκπτωση!', 3, 5);
