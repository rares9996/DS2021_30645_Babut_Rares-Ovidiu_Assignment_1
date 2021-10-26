DROP TABLE IF EXISTS "role";

CREATE TABLE role
(
    role_id serial PRIMARY KEY,
    name    varchar(250) NOT NULL
);

INSERT INTO "city_db".role(role_id, name)
VALUES (1, 'USER');

INSERT INTO "city_db".role(role_id, name)
VALUES (2, 'ADMIN');

alter sequence role_role_id_seq restart with 3;

