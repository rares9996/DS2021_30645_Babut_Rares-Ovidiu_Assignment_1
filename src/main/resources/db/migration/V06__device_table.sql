DROP TABLE IF EXISTS "device";

CREATE TABLE "device"
(
    device_id    serial PRIMARY KEY,
    description       varchar(250),
    address    varchar(250),
    maximum_energy_consumption   FLOAT ,
    average_energy_consumption   FLOAT,
    sensor_id INTEGER NOT NULL,
    foreign key (sensor_id) references sensor (sensor_id)
);
