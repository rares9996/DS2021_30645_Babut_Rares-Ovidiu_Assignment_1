package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

  @Query(value = "SELECT s from Sensor s left join Device d on s.id = d.sensor.id where d.id is null")
  List<Sensor> getAllSensorsWithoutDevices();
}
