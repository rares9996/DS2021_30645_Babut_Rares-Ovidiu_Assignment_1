DROP TABLE IF EXISTS "device";

CREATE TABLE "device"
(
    device_id                  serial PRIMARY KEY,
    description                varchar(250),
    address                    varchar(250),
    maximum_energy_consumption FLOAT,
    average_energy_consumption FLOAT,
    sensor_id                  INTEGER,
    foreign key (sensor_id) references sensor (sensor_id) on delete SET NULL
);

INSERT INTO "city_db".device(device_id, description, address, maximum_energy_consumption, average_energy_consumption,
                             sensor_id)
VALUES (1, 'descriere device 1', 'adresa device 1', 120, 60, 1);
INSERT INTO "city_db".device(device_id, description, address, maximum_energy_consumption, average_energy_consumption,
                             sensor_id)
VALUES (2, 'descriere device 2', 'adresa device 2', 23, 11, 2);
INSERT INTO "city_db".device(device_id, description, address, maximum_energy_consumption, average_energy_consumption,
                             sensor_id)
VALUES (3, 'descriere device 3', 'adresa device 3', 34, 22, 3);
INSERT INTO "city_db".device(device_id, description, address, maximum_energy_consumption, average_energy_consumption,
                             sensor_id)
VALUES (4, 'descriere device 4', 'adresa device 4', 45, 33, 4);

alter sequence device_device_id_seq restart with 5;
