DROP TABLE IF EXISTS "sensor";

CREATE TABLE "sensor"
(
    sensor_id    serial PRIMARY KEY,
    description  varchar(250),
    maximum_value FLOAT
);

INSERT INTO "city_db".sensor(sensor_id, description, maximum_value )
VALUES (1, 'descriere sensor 1',120);
INSERT INTO "city_db".sensor(sensor_id, description, maximum_value )
VALUES (2, 'descriere sensor 2',150);
INSERT INTO "city_db".sensor(sensor_id, description, maximum_value )
VALUES (3, 'descriere sensor 3',333);
INSERT INTO "city_db".sensor(sensor_id, description, maximum_value )
VALUES (4, 'descriere sensor 4',444);

alter sequence sensor_sensor_id_seq restart with 5;
