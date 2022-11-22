INSERT INTO `customers`  (company_name, first_name, last_name, billing_address, city, state_or_province, zip_code, email,  company_website, phone_number, fax_number, ship_address, ship_city, ship_state_or_province, ship_zip_code, ship_phone_number) VALUES ('PT KRUNG', 'Radian', 'Malik', 'Jakarta Barat', 'Jakarta', 'DKI Jakarta', '17121', 'rm@yahoo.co.id','www.krung.com','6285670539466','87356363','Jakarta', 'Jakarta Barat', 'DKI Jakarta', '17121', '6285670539466');
INSERT INTO `customers`  (company_name, first_name, last_name, billing_address, city, state_or_province, zip_code, email,  company_website, phone_number, fax_number, ship_address, ship_city, ship_state_or_province, ship_zip_code, ship_phone_number) VALUES ('PT AURA', 'LIngga', 'Edo', 'Jakarta Barat', 'Jakarta', 'DKI Jakarta', '17121', 'rm@yahoo.co.id','www.aura.com','6281270896574','87355454','Jakarta', 'Jakarta Barat', 'DKI Jakarta', '17121', '6281270896574');
INSERT INTO `customers`  (company_name, first_name, last_name, billing_address, city, state_or_province, zip_code, email,  company_website, phone_number, fax_number, ship_address, ship_city, ship_state_or_province, ship_zip_code, ship_phone_number) VALUES ('PT YAHSA', 'Kusman', 'Wahyudin', 'Jakarta Barat', 'Jakarta', 'DKI Jakarta', '17121', 'rm@yahoo.co.id','www.yahsa.com','6285670145399','87377723','Jakarta', 'Jakarta Barat', 'DKI Jakarta', '17121', '6285670145399');

INSERT INTO `employees` (first_name, last_name, title, work_phone) VALUES ('Leo', 'Watson', 'staff', '6285670539487');
INSERT INTO `employees` (first_name, last_name, title, work_phone) VALUES ('Ikhsan', 'Gursala', 'staff', '6281270553792');
INSERT INTO `employees` (first_name, last_name, title, work_phone) VALUES ('Hariri', 'Aulia', 'staff', '6288840531340');

INSERT INTO `shipping_methods` (shipping_method) VALUES ('JNE');
INSERT INTO `shipping_methods` (shipping_method) VALUES ('TIKI');
INSERT INTO `shipping_methods` (shipping_method) VALUES ('J&T');

INSERT INTO `products` (product_name, unit_price, in_stock) VALUES ('Laptop Lenovo', 8000000, 1);
INSERT INTO `products` (product_name, unit_price, in_stock) VALUES ('IPhone 12', 12000000, 1);
INSERT INTO `products` (product_name, unit_price, in_stock) VALUES ('Handphone ASUS ROG', 16000000, 1);
INSERT INTO `products` (product_name, unit_price, in_stock) VALUES ('Laptop Acer', 6000000, 1);
INSERT INTO `products` (product_name, unit_price, in_stock) VALUES ('Smartwatch Samsung', 4000000, 1);

INSERT INTO `orders` (customer_id, employees_id, order_date, purchase_order_number, ship_date, shipping_method_id, freight_charge, taxes, payment_received, comment) VALUES (1, 1, NOW(), 1, NOW(), 1, 19000, 10, 1, 'paid');
INSERT INTO `orders` (customer_id, employees_id, order_date, purchase_order_number, ship_date, shipping_method_id, freight_charge, taxes, payment_received, comment) VALUES (2, 2, NOW(), 2, NOW(), 2, 9000, 10, 1, 'paid');
INSERT INTO `orders` (customer_id, employees_id, order_date, purchase_order_number, ship_date, shipping_method_id, freight_charge, taxes, payment_received, comment) VALUES (3, 3, NOW(), 3, NOW(), 3, 27000, 10, 1, 'paid');
INSERT INTO `orders` (customer_id, employees_id, order_date, purchase_order_number, ship_date, shipping_method_id, freight_charge, taxes, payment_received, comment) VALUES (1, 2, NOW(), 4, NOW(), 1, 19000, 10, 0, 'waiting payment');
INSERT INTO `orders` (customer_id, employees_id, order_date, purchase_order_number, ship_date, shipping_method_id, freight_charge, taxes, payment_received, comment) VALUES (2, 1, NOW(), 5, NOW(), 2, 9000, 10, 0, 'waiting payment');

INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (1, 1, 2, 8000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (1, 2, 2, 12000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (1, 3, 2, 16000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (2, 3, 2, 16000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (3, 4, 2, 6000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (4, 3, 2, 16000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (4, 4, 2, 6000000, 5000);
INSERT INTO `order_details` (order_id, product_id, quantity, unit_price, discount) VALUES (5, 5, 2, 4000000, 5000);