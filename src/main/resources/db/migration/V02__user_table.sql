DROP TABLE IF EXISTS "user";

CREATE TABLE "user"
(
    user_id    serial PRIMARY KEY,
    name       varchar(250),
    birth_date date,
    address    varchar(250),
    username   varchar(250) UNIQUE,
    password   varchar(250)
);
INSERT INTO "city_db".user(user_id,name,birth_date,address,username,password)
VALUES (1, 'Rares','10-11-1999','Str Maramures nr 25', 'raresbabut@gmail.com','$2a$10$5MK7S9Cpa85uf5oAYK2Ij.Um5dagOcxynMawl.OfaJtOPC998BI.i');
INSERT INTO "city_db".user(user_id,name,birth_date,address,username,password)
VALUES (2, 'Rares','10-11-1999','Str Maramures nr 25', 'admin@gmail.com','$2a$10$5MK7S9Cpa85uf5oAYK2Ij.Um5dagOcxynMawl.OfaJtOPC998BI.i');

alter sequence user_user_id_seq restart with 3;
