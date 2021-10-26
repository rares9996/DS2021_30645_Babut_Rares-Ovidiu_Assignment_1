package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
