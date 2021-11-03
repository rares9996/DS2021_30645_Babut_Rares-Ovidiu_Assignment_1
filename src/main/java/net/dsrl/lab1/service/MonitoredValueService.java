package net.dsrl.lab1.service;

import net.dsrl.lab1.model.MonitoredValue;
import net.dsrl.lab1.model.Sensor;
import net.dsrl.lab1.repository.MonitoredValueRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoredValueService {

  private final MonitoredValueRepository monitoredValueRepository;
  private final SensorService sensorService;

  public MonitoredValueService(
      MonitoredValueRepository monitoredValueRepository, SensorService sensorService) {
    this.monitoredValueRepository = monitoredValueRepository;
    this.sensorService = sensorService;
  }

  public List<MonitoredValue> getMonitoredValuesOfTodayForUser(String username) {
    List<Sensor> sensors = sensorService.getSensorOfUser(username);
    List<MonitoredValue> monitoredValues = new ArrayList<>();
    for (Sensor sensor : sensors) {
      for(MonitoredValue monitoredValue: sensor.getMonitoredValue())
      {
        if(monitoredValue.getTimestamp().toLocalDate().equals(LocalDate.now()))
        {
          monitoredValues.add(monitoredValue);
        }
      }
    }
    return monitoredValues;
  }

}
