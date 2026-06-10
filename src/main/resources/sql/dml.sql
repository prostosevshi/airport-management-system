INSERT INTO airports (airport_name, airport_location)
VALUES
('Tbilisi Airport', 'Georgia'),
('London Airport', 'London');

INSERT INTO planes (model, number_of_engines, number_of_seats, airport_id)
VALUES
('Boeing 737', 2, 180, 1),
('Airbus A320', 2, 150, 2);

INSERT INTO employees (name, age, salary, airport_id)
VALUES
('John Smith', 35, 5000, 1),
('Alice Brown', 29, 4500, 2);

INSERT INTO guests (name, age, passport_number, plane_id)
VALUES
('Michael Johnson', 30, 123456, 1),
('Emma Wilson', 27, 654321, 2);

INSERT INTO bookings (booking_number, booking_date, airport_id, guest_id)
VALUES
(1001, '2026-05-10', 1, 1),
(1002, '2026-05-11', 2, 2);

INSERT INTO lunch_menus (plane_id)
VALUES
(1),
(2);

INSERT INTO products (name, calories, price, fresh, lunch_menu_id)
VALUES
('Chicken Sandwich', 450, 12, 1, 1),
('Orange Juice', 150, 5, 1, 2);

INSERT INTO card_payments
(card_number, payment_number, payment_amount, payment_date, booking_id)
VALUES
(11112222, 5001, 300, '2026-05-10', 1),
(33334444, 5002, 450, '2026-05-11', 2);