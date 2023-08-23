DROP TABLE IF EXISTS simple_items CASCADE;
CREATE TABLE simple_items (id bigserial PRIMARY KEY, title VARCHAR(255), price INT);
INSERT INTO simple_items (title, price) VALUES ('Laptop', 1000), ('PlayStation', 2000), ('Monitor', 500);
