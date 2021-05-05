INSERT INTO users (email, password, role, name, address, postal, city, phone)
VALUES ('test@mail.dk','test123','customer','hans','rababervej',2300,'amager',11223344);

INSERT INTO parts (name, parts_per_unit, unit)
VALUES ('25x200	mm.	trykimp. Brædt', 4, 'stk');

INSERT INTO shed (length, width)
VALUES (200, 200);

INSERT INTO partlists (description, price, length, width, parts_id, shed_id)
VALUES ('I am not really sure what to put here', 42069.96, 500.00, 800.00, 1, 1);

INSERT INTO orders (width, length, status, user_id, partlist_id, timestamp)
VALUES (500, 800, 'pending', 2, 1, CURRENT_TIMESTAMP());