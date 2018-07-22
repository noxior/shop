DELETE FROM user_roles;
DELETE FROM carts;
DELETE FROM fuel_stations;
DELETE FROM order_details;
DELETE FROM fuels;
DELETE FROM orders;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com', '{noop}admin');

  INSERT INTO carts (user_id, fuel_station_name, amount, price, fuel_name, quantity) VALUES
    (100000, 'OKKO', '40.4', '22.2', 'А92', '2'),
    (100000, 'Neftek', '23.4', '23.4', 'А95', '1'),
    (100000, 'Neftek', '60', '20', 'А95+', '3'),
    (100000, 'Neftek', '73.2', '24.4', 'ГАЗ', '3'),
    (100000, 'WOG', '250', '25', 'ДТ', '10'),
    (100000, 'WOG', '120', '12', 'ГАЗ', '10'),
    (100001, 'Авиас', '120', '12', 'ГАЗ', '10'),
    (100001, 'Авиас', '120', '10', 'А92', '12');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO orders (date_time, order_address, user_id, status) VALUES
  ('2015-05-30 10:00:00','улица Воронцова 4/11',  100000, 'REJECTED'),
  ('2015-06-01 14:00:00', 'улица Воронцова 4/11', 100001, 'DELIVERED_TO_CLIENT'),
  ('2015-06-01 21:00:00', 'улица Лебедева 5/11', 100001, 'PROCESSING'),
  ('2015-06-01 21:00:00', 'улица Лебедева 5/11', 100001, 'COMFIRMED');

INSERT INTO order_details (fuel_station_name, amount, price, fuel_name, quantity, order_id) VALUES
    ('OKKO', '40.4', '22.2', 'А92', '2', 100010),
    ('Neftek', '23.4', '23.4', 'А95', '1', 100010),
    ('Neftek', '60', '20', 'А95+', '3', 100013),
    ('Neftek', '73.2', '24.4', 'ГАЗ', '3', 100012),
    ('WOG', '250', '25', 'ДТ', '10', 100011),
    ('WOG', '120', '12', 'ГАЗ', '10', 100013),
    ('Авиас', '120', '12', 'ГАЗ', '10', 100012),
    ('Авиас', '120', '10', 'А92', '12', 100011);

INSERT INTO fuel_stations (name) VALUES
  ('Neftek'),
  ('Авиас'),
  ('OKKO'),
  ('WOG');

INSERT INTO fuels (name, price, fuelStationId) VALUES
  ('95', '34.1', 100022),
  ('80', '34.2', 100022),
  ('95+', '34.4', 100023),
  ('95+', '34.2', 100025),
  ('95+', '34.5', 100024);


