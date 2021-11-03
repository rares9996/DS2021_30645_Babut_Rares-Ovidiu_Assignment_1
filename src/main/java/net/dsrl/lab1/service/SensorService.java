package net.dsrl.lab1.service;

import net.dsrl.lab1.controller.handlers.exception.ResourceNotFoundException;
import net.dsrl.lab1.mapper.SensorMapper;
import net.dsrl.lab1.model.Device;
import net.dsrl.lab1.model.Sensor;
import net.dsrl.lab1.model.dto.SensorDto;
import net.dsrl.lab1.repository.SensorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SensorService {

  private final SensorRepository sensorRepository;
  private final SensorMapper sensorMapper;
  private final DeviceService  deviceService;

  public SensorService(SensorRepository sensorRepository, SensorMapper sensorMapper, DeviceService deviceService) {
    this.sensorRepository = sensorRepository;
    this.sensorMapper = sensorMapper;
    this.deviceService = deviceService;
  }

  public List<Sensor> getAll() {
    return sensorRepository.findAll();
  }

  public Sensor getById(Long id) {
    return sensorRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Sensor not found for id:" + id));
  }

  public Sensor createSensor(SensorDto sensorDto) {
    Sensor sensor = sensorMapper.convertToEntity(sensorDto);
    return sensorRepository.save(sensor);
  }

  public Sensor updateSensor(SensorDto sensorDto) {
    Sensor sensor = getById(sensorDto.getId());
    sensor.setDescription(sensorDto.getDescription());
    sensor.setMaximumValue(sensorDto.getMaximumValue());
    sensor.setMonitoredValue(sensorDto.getMonitoredValue());
    return sensorRepository.save(sensor);
  }

  @Transactional
  public void deleteSensor(Long id) {
    sensorRepository.deleteById(id);
  }

  public List<Sensor> getSensorsWithoutDevice()
  {
    return sensorRepository.getAllSensorsWithoutDevices();
  }

  public List<Sensor> getSensorOfUser(String username)
  {
    Set<Device> devices = deviceService.getDeviceOfUser(username);
    return devices.stream().map(Device::getSensor).collect(Collectors.toList());
  }
}
