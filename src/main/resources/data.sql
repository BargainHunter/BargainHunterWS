INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Diamantis Masoutis AE', 'Greece', 'Thessaloniki', '_', '_', '57001');
INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Gatidis S.A', 'Greece', 'Serres', '_', '_', '62122');
INSERT INTO COMPANY (company_name, country, city, address, address_no, zip) VALUES ('Public', 'Greece', 'Athens', '_', '_', '16674');

INSERT INTO BRANCH (branch_name, company_id) VALUES ('Masoutis', 1);
INSERT INTO BRANCH (branch_name, company_id) VALUES ('Gatidis', 2);
INSERT INTO BRANCH (branch_name, company_id) VALUES ('Public', 3);

INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Miaouli', '4', 'Serres', 'Greece', 41.089438, 23.544533, 62121, 1);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Patriarxou Grigoriou Z', '10', 'Serres', 'Greece', 41.086757, 23.545687, 62125, 1);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Karaiskaki', '19', 'Serres', 'Greece', 41.0908408, 23.5414613, 62100, 2);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Konstantinoupolews', '4', 'Serres', 'Greece', 41.090320, 23.551747, 62122, 2);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Vasileiou', '14', 'Serres', 'Greece', 41.0908245, 23.5479897, 62121, 2);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Tsalopoulou', '9', 'Serres', 'Greece', 41.089644, 23.550258, 62122, 3);
INSERT INTO STORE (address, address_no, city, country, latitude, longitude, zip, branch_id) VALUES ('Tsimiski', '24', 'Thessaloniki', 'Greece', 40.6336695, 22.9410913, 54624, 3);

INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Mini κρουασάν βουτύρου ALFA', '2014-11-13', 4.64, 6, '2015-3-19', 'Mini κρουασάν βουτύρου ALFA 1+1 ΔΩΡΟ!', 1);
INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Chips Lays Xtra waves', '2014-11-13', 0.83, 1, '2015-3-19', 'Chips Lays Xtra waves 23% φθηνότερα!', 1);
INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Ψωμί Πολύσπορο', '2014-11-13', 0.80, 1.2, '2015-3-19', 'Έκπτωση στο πολύσπορο -0,10 λεπτά!', 2);
INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Προφιτερόλ', '2014-11-13', 1.20, 2, '2015-3-19', 'Προφιτερόλ -0,30 λεπτά!', 2);
INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Laptop Dell Inspiron Q15R', '2014-11-13', 365, 500, '2015-3-19', 'Λάπτοπ Dell Inspiron Q15R - Laptop - Core i3-2310M 2.10 GHz - 15.6" LED 20% έκπτωση!', 3);
INSERT INTO OFFER (description, start_date, price, old_price, exp_date, title, branch_id) VALUES ('Asus MeMo Pad 7 ME70C', '2014-11-13', 100, 120, '2015-3-19', 'Asus MeMo Pad 7 ME70C - Tablet 7" -30 ευρω έκπτωση!', 3);

INSERT INTO CATEGORY (description) VALUES ('Τρόφιμα');
INSERT INTO CATEGORY (description) VALUES ('Ηλεκτρονικά');

INSERT INTO SUBCATEGORY (description, category_id) VALUES ('Γλυκά', 1);
INSERT INTO SUBCATEGORY (description, category_id) VALUES ('Σνάκς', 1);
INSERT INTO SUBCATEGORY (description, category_id) VALUES ('Αρτοσκευάσματα', 1);
INSERT INTO SUBCATEGORY (description, category_id) VALUES ('Tablet', 2);
INSERT INTO SUBCATEGORY (description, category_id) VALUES ('Laptop', 2);

INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (1, 1);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (1, 3);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (2, 2);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (3, 3);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (4, 1);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (5, 4);
INSERT INTO OFFER_SUBCATEGORY (offer_id, subcategory_id) VALUES (6, 5);