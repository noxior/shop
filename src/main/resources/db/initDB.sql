DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS fuels;
DROP TABLE IF EXISTS carts;
DROP TABLE IF EXISTS fuel_stations;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR                 NOT NULL,
  email      VARCHAR                 NOT NULL,
  password   VARCHAR                 NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL,
  enabled    BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE orders (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id       INTEGER   NOT NULL,
  date_time     TIMESTAMP NOT NULL,
  order_address VARCHAR   NOT NULL,
  status        VARCHAR   NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX orders_unique_id_datetime_status_idx
  ON orders (user_id, date_time, status);

CREATE TABLE order_details (
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  fuel_station_name VARCHAR        NOT NULL,
  amount            NUMERIC(13, 2) NOT NULL,
  price             NUMERIC(13, 2) NOT NULL,
  fuel_name         VARCHAR        NOT NULL,
  quantity          INTEGER        NOT NULL,
  order_id          INTEGER        NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE
);

CREATE TABLE fuel_stations (
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR NOT NULL
);
CREATE UNIQUE INDEX fuel_station_unique_name_idx
  ON fuel_stations (name);

CREATE TABLE fuels
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name          VARCHAR                 NOT NULL,
  price         NUMERIC(13, 2)          NOT NULL,
  enabled       BOOL DEFAULT TRUE       NOT NULL,
  fuelStationId INTEGER                 NOT NULL REFERENCES fuel_stations (id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE UNIQUE INDEX fuel_station_uni_idx
  ON fuels (name, fuelStationId);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE carts (
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id           INTEGER        NOT NULL,
  fuel_station_name VARCHAR        NOT NULL,
  amount            NUMERIC(13, 2) NOT NULL,
  price             NUMERIC(13, 2) NOT NULL,
  fuel_name         VARCHAR        NOT NULL,
  quantity          INTEGER        NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);