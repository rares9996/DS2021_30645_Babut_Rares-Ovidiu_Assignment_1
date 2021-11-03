DROP TABLE IF EXISTS user_roles;

CREATE TABLE user_roles
(
    id      serial PRIMARY KEY,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    foreign key (user_id) references "user" (user_id) ON DELETE CASCADE,
    foreign key (role_id) references "role" (role_id) ON DELETE CASCADE
);
INSERT INTO "city_db".user_roles(id, user_id, role_id)
VALUES (1, 1, 1);
INSERT INTO "city_db".user_roles(id, user_id, role_id)
VALUES (2, 2, 1);
INSERT INTO "city_db".user_roles(id, user_id, role_id)
VALUES (3, 3, 2);

alter sequence user_roles_id_seq restart with 4;
