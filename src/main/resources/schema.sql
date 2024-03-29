CREATE TABLE IF NOT EXISTS customer (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  bonus_points BIGINT
);

CREATE TABLE IF NOT EXISTS transaction (
  id INT AUTO_INCREMENT PRIMARY KEY,
  price DECIMAL(10, 2),
  date TIMESTAMP,
  customer_id INT,
  bonus_points BIGINT,
  FOREIGN KEY (customer_id) REFERENCES customer (id)
);

INSERT INTO customer (name, surname, bonus_points) VALUES ('John', 'Doe', 127);
INSERT INTO customer (name, surname, bonus_points) VALUES ('Alice', 'Smith', 175);
INSERT INTO customer (name, surname, bonus_points) VALUES ('Bob', 'Johnson', 245);

INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (10.5, '2024-01-19 10:00:00', 1, 10);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (25.75, '2024-01-19 10:00:00', 2, 20);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (50.0, '2024-01-19 10:00:00', 3, 30);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (15.0, '2024-01-19 10:00:00', 1, 15);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (33.25, '2024-01-19 10:00:00', 2, 25);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (62.5, '2024-01-19 10:00:00', 3, 35);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (20.75, '2023-12-19 10:00:00', 1, 12);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (45.5, '2023-12-19 10:00:00', 2, 22);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (80.0, '2023-12-19 10:00:00', 3, 32);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (18.25, '2023-12-19 10:00:00', 1, 14);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (39.75, '2023-12-19 10:00:00', 2, 24);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (72.5, '2023-12-19 10:00:00', 3, 34);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (25.0, '2023-12-19 10:00:00', 1, 16);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (55.25, '2023-12-19 10:00:00', 2, 26);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (95.0, '2023-11-19 10:00:00', 3, 36);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (30.75, '2023-11-19 10:00:00', 1, 18);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (66.5, '2023-11-19 10:00:00', 2, 28);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (110.0, '2023-11-19 10:00:00', 3, 38);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (35.25, '2023-11-19 10:00:00', 1, 20);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (77.5, '2024-02-08 14:05:00', 2, 30);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (125.0, '2024-02-08 14:05:00', 3, 40);
INSERT INTO transaction (price, date, customer_id, bonus_points) VALUES (40.75, '2024-02-08 14:05:00', 1, 22);
