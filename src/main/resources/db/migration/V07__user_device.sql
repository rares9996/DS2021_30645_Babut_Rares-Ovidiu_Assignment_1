DROP TABLE IF EXISTS "user_device";

CREATE TABLE "user_device"
(
    id      serial PRIMARY KEY,
    user_id INTEGER NOT NULL,
    device_id INTEGER NOT NULL,
    foreign key (user_id) references "user" (user_id) ON DELETE CASCADE,
    foreign key (device_id) references "device" (device_id) ON DELETE CASCADE
);
INSERT INTO "city_db".user_device(id, user_id, device_id)
VALUES (1,1,1);
INSERT INTO "city_db".user_device(id, user_id, device_id)
VALUES (2,1,2);
INSERT INTO "city_db".user_device(id, user_id, device_id)
VALUES (3,2,3);
INSERT INTO "city_db".user_device(id, user_id, device_id)
VALUES (4,2,4);

alter sequence user_device_id_seq restart with 5;


