DROP TABLE IF EXISTS "sensor";

CREATE TABLE "sensor"
(
    sensor_id    serial PRIMARY KEY,
    description  varchar(250),
    maximum_value FLOAT,
    monitored_id INTEGER NOT NULL,
    foreign key (monitored_id) references monitored_value (monitored_id)
);
