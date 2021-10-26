DROP TABLE IF EXISTS "user_device";

CREATE TABLE "user_device"
(
    id      serial PRIMARY KEY,
    user_id INTEGER NOT NULL,
    device_id INTEGER NOT NULL,
    foreign key (user_id) references "user" (user_id),
    foreign key (device_id) references "device" (device_id)
);
