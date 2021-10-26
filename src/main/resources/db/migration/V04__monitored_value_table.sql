DROP TABLE IF EXISTS "monitored_value";

CREATE TABLE "monitored_value"
(
    monitored_id        serial PRIMARY KEY,
    timestamp           timestamp,
    energy_consumption FLOAT
);

INSERT INTO "city_db".monitored_value(monitored_id, timestamp, energy_consumption)
VALUES (1, '2021-10-11', 1);
