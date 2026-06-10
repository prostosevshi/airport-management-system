--3.1)10 statements for updating.
UPDATE airports
SET airport_name = 'Batumi Airport'
WHERE id = 1;

UPDATE airports
SET airport_location = 'United Kingdom'
WHERE id = 2;

UPDATE planes
SET number_of_seats = 200
WHERE id = 1;

UPDATE planes
SET model = 'Boeing 777'
WHERE id = 2;

UPDATE employees
SET salary = 6000
WHERE id = 1;

UPDATE employees
SET age = 31
WHERE id = 2;

UPDATE guests
SET name = 'David Miller'
WHERE id = 1;

UPDATE bookings
SET booking_date = '2026-06-01'
WHERE id = 2;

UPDATE products
SET price = 15
WHERE id = 1;

UPDATE card_payments
SET payment_amount = 700
WHERE id = 2;


--3.2)10 statements for deletions.
DELETE FROM card_payments
WHERE id = 1;

DELETE FROM products
WHERE id = 2;

DELETE FROM lunch_menus
WHERE id = 2;

DELETE FROM bookings
WHERE id = 2;

DELETE FROM guests
WHERE id = 2;

DELETE FROM employees
WHERE id = 2;

DELETE FROM planes
WHERE id = 2;

DELETE FROM airports
WHERE id = 2;

DELETE FROM products
WHERE id = 1;

DELETE FROM card_payments
WHERE id = 2;


--3.3)1 big statement to join all tables in the database.
SELECT
    a.airport_name,
    a.airport_location,
    p.model,
    p.number_of_seats,
    e.name AS employee_name,
    g.name AS guest_name,
    b.booking_number,
    pr.name AS product_name,
    cp.payment_amount
FROM airports a
JOIN planes p
    ON a.id = p.airport_id
JOIN employees e
    ON a.id = e.airport_id
JOIN guests g
    ON p.id = g.plane_id
JOIN bookings b
    ON g.id = b.guest_id
JOIN lunch_menus lm
    ON p.id = lm.plane_id
JOIN products pr
    ON lm.id = pr.lunch_menu_id
JOIN card_payments cp
    ON b.id = cp.booking_id;


--3.4)5 statements with left, right, inner, full joins.
SELECT *
FROM airports a
INNER JOIN planes p
ON a.id = p.airport_id;

SELECT *
FROM airports a
LEFT JOIN employees e
ON a.id = e.airport_id;

SELECT *
FROM planes p
RIGHT JOIN airports a
ON p.airport_id = a.id;

SELECT *
FROM guests g
LEFT JOIN bookings b
ON g.id = b.guest_id
UNION
SELECT *
FROM guests g
RIGHT JOIN bookings b
ON g.id = b.guest_id;

SELECT *
FROM lunch_menus lm
LEFT JOIN products p
ON lm.id = p.lunch_menu_id;


--3.5)7 statements with aggregate functions and group by and without having.
SELECT airport_id, COUNT(*) AS total_planes
FROM planes
GROUP BY airport_id;

SELECT airport_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY airport_id;

SELECT airport_id, MAX(number_of_seats) AS max_seats
FROM planes
GROUP BY airport_id;

SELECT lunch_menu_id, MIN(price) AS min_price
FROM products
GROUP BY lunch_menu_id;

SELECT booking_id, SUM(payment_amount) AS total_payment
FROM card_payments
GROUP BY booking_id;

SELECT plane_id, COUNT(*) AS total_guests
FROM guests
GROUP BY plane_id;

SELECT lunch_menu_id, AVG(calories) AS avg_calories
FROM products
GROUP BY lunch_menu_id;


--3.6)7 statements with aggregate functions and group by and with having.
SELECT airport_id, COUNT(*) AS total_planes
FROM planes
GROUP BY airport_id
HAVING COUNT(*) > 0;

SELECT airport_id, AVG(salary) AS avg_salary
FROM employees
GROUP BY airport_id
HAVING AVG(salary) > 4000;

SELECT airport_id, MAX(number_of_seats) AS max_seats
FROM planes
GROUP BY airport_id
HAVING MAX(number_of_seats) > 160;

SELECT booking_id, SUM(payment_amount) AS total_payment
FROM card_payments
GROUP BY booking_id
HAVING SUM(payment_amount) > 200;

SELECT lunch_menu_id, MIN(price) AS min_price
FROM products
GROUP BY lunch_menu_id
HAVING MIN(price) > 3;

SELECT plane_id, COUNT(*) AS total_guests
FROM guests
GROUP BY plane_id
HAVING COUNT(*) >= 1;

SELECT lunch_menu_id, AVG(calories) AS avg_calories
FROM products
GROUP BY lunch_menu_id
HAVING AVG(calories) > 100;