DROP TABLE IF EXISTS "monitored_value";

CREATE TABLE "monitored_value"
(
    monitored_id        serial PRIMARY KEY,
    timestamp           timestamp,
    energy_consumption FLOAT
);

INSERT INTO "city_db".monitored_value(monitored_id, timestamp, energy_consumption)
VALUES (1, '2021-10-11', 1);
INSERT INTO "city_db".monitored_value(monitored_id, timestamp, energy_consumption)
VALUES (2, '2021-09-11', 111);
INSERT INTO "city_db".monitored_value(monitored_id, timestamp, energy_consumption)
VALUES (3, '2021-08-11', 222);
INSERT INTO "city_db".monitored_value(monitored_id, timestamp, energy_consumption)
VALUES (4, '2021-07-11', 333);

alter sequence monitored_value_monitored_id_seq restart with 5;
