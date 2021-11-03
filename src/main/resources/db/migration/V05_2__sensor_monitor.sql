DROP TABLE IF EXISTS sensor_monitor;

CREATE TABLE sensor_monitor
(
    id      serial PRIMARY KEY,
    sensor_id INTEGER NOT NULL,
    monitored_id INTEGER NOT NULL,
    foreign key (sensor_id) references "sensor" (sensor_id) ON DELETE CASCADE,
    foreign key (monitored_id) references "monitored_value" (monitored_id) ON DELETE CASCADE
);
INSERT INTO "city_db".sensor_monitor(id, sensor_id, monitored_id)
VALUES (1, 1, 1);
INSERT INTO "city_db".sensor_monitor(id, sensor_id, monitored_id)
VALUES (2, 2, 2);
INSERT INTO "city_db".sensor_monitor(id, sensor_id, monitored_id)
VALUES (3, 3, 3);
INSERT INTO "city_db".sensor_monitor(id, sensor_id, monitored_id)
VALUES (4, 4, 4);

alter sequence sensor_monitor_id_seq restart with 5;
