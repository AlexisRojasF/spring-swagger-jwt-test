INSERT INTO user_db (user_id ,passw, name_one, name_others, last_name_one, last_name_two, country, identification, id_num, email, create_at, status) VALUES(1L,'12345', 'maria', 'jose', 'chavez', 'f', 'cop', 'cc', '1116270829', 'mariajose@maria.com', '2022-10-13 00:30:00.000', true);
INSERT INTO user_db (user_id,passw, name_one, name_others, last_name_one, last_name_two, country, identification, id_num, email, create_at, status) VALUES(2L,'12345', 'brian', 'alexis', 'rojas', 'f', 'cop', 'cc', '1116270821', 'alexisrojas@rojas.com', '2022-10-13 00:30:00.000', true);
INSERT INTO round (entry, leave, create_at, status, user_id, area) VALUES('2022-10-13 01:30:00.000', '2022-10-13 03:30:00.000', '2022-10-13 01:30:00.000', true, 1L, 'uno');
INSERT INTO round (entry, leave, create_at, status, user_id, area) VALUES('2022-10-13 01:30:00.000', '2022-10-13 03:30:00.000', '2022-10-13 01:30:00.000', true, 1L, 'dos');
INSERT INTO round (entry, leave, create_at, status, user_id, area) VALUES('2022-10-13 01:30:00.000', '2022-10-13 03:30:00.000', '2022-10-13 01:30:00.000', true, 2L, 'uno');
INSERT INTO area (name_area, create_at, status) VALUES('uno', '2022-10-13 01:30:00.000', true);
INSERT INTO area (name_area, create_at, status) VALUES('dos', '2022-10-13 01:30:00.000', true);
INSERT INTO area (name_area, create_at, status) VALUES('tre', '2022-10-13 01:30:00.000', true);