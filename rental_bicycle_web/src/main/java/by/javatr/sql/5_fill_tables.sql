SET NAMES 'compatibility';

INSERT INTO rental_bicycle_web.vitualcard(vitualCard_id, vitualrCard_name, vitualCard_balance, vitualCard_currency) VALUES
(1, 'admin', 100000.00, '933'),
(2, 'basic', 12.00, '933');

INSERT INTO rental_bicycle_web.user(user_id, user_login, user_password, user_virtualcard_id, user_role) VALUES
(1, 'admin', '12345', 1, 'admin'),
(2, 'gave', '11111', 2, 'user');

INSERT INTO rental_bicycle_web.userinfo(userInfo_id, userInfo_surname, userInfo_name, userInfo_secondName, userInfo_birthDate, userInfo_passportIssueDate, userInfo_passportIssuingAuthority, userInfo_passportIdentificationNumber, userInfo_passportSerialNumber, userInfo_passportAdressRegistration, userInfo_passportAdressResidence, userInfo_phoneNumber, userInfo_secondPhoneNumber, userInfo_email) VALUES
(1, 'Ivanov', 'Ivan', 'Ivanovich', '25.02.1990', '2019-07-04', 'Oktiabrskoje RUVD g. Minska', '7123456А001РВ3 ', 'MP1589621', 'Belarus, Minsk, Uralskaja - str, 25, 156', 'Belarus, Minsk, Uralskaja - str, 25, 156', 80297648022, 80297895266, 'yellow@yandex.ru'),
(2, 'Petrov', 'Oleg', 'Petrovich', '25.06.1926', '2019-07-01', 'Centralnoje RUVD g.Minska', '4131087В052РВ4', 'MP1451118', 'Bularus, Lida, Gagarina - str, 15, 123', 'Belarus, Minsk, Kizhevatova, 60, 3', 80295698989, 80297777722, 'red@yandex.ru');


INSERT INTO rental_bicycle_web.company(company_id, company_name, company_accountNumberOfPayer) VALUES
(1, 'Private enterprise "At the speed of wind"', 192693197);

INSERT INTO rental_bicycle_web.location(location_id, location_name, location_company_id, location_country, location_city, location_street, location_house, location_office, location_index, location_phone, location_secondPhone, location_photo) VALUES
(1, 'In the centre', 1, 'Belarus', 'Minsk', 'Niomanskaya-str.', '20', '3', '220115', 80297772255, 80297772256, NULL),
(2, 'At berth', 1, 'Belarus', 'Minsk', 'Kizhevatova-str.', '10', '1', '220117', 80297772066, 80297772067, NULL),
(3, 'Always near', 1, 'Belarus', 'Minsk', 'Prityckogo-str.', '12', '20', '220200', 80297771515, 80297771517, NULL),
(4, 'On periphery', 1, 'Belarus', 'Minsk', 'Pobeditelej-pr.', '11', '10', '220118', 80298252015, 80298005060, NULL),
(5, 'Nearby', 1, 'Belarus', 'Minsk', 'Rokossovskigo-pr.', '12', '120', '220116', 80297702020, 80297702021, NULL),
(6, 'Always', 1, 'Belarus', 'Minsk', 'Kazinca-pr.', '15', '16', '220102', 80297001010, 80297001011, NULL),
(7, 'In the way', 1, 'Belarus', 'Minsk', 'Vielka-str.', '20A', '1', '220111', 80292589878, 80295689555, NULL),
(8, 'Cudny', 1, 'Belarus', 'Minsk', 'Cudna-str.', '10B', '2', '220103', 80291005020, 80291005060, NULL),
(9, 'Conveniently', 1, 'Belarus', 'Minsk', 'Syrganova-str.', '102', '25', '220500', 80297485898, 80297589658, NULL);

INSERT INTO rental_bicycle_web.price(price_id, price_currency, price_unitTime, price_rate) VALUES
(1, 933, 'min', 0.10),
(2, 933, 'min', 0.12),
(3, 933, 'min', 0.15),
(4, 933, 'min', 0.20);

INSERT INTO rental_bicycle_web.payment(payment_id, payment_amount, payment_virtualCard_id, payment_company_id, payment_ifPaid) VALUES
(1, NULL, 2, 1, 0);


INSERT INTO rental_bicycle_web.rent(rent_id, rent_user_id, rent_bicycle_id, rent_start_time, rent_finish_time, rent_finishLocation_id, rent_payment_id) VALUES
(1, 2, 4, '2019-07-06 08:15:00', '2019-07-06 08:20:00', 8, 1);



