package net.dsrl.lab1.mapper;

import net.dsrl.lab1.model.Sensor;
import net.dsrl.lab1.model.dto.SensorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
  private final ModelMapper modelMapper;

  public SensorMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public SensorDto convertToDto(Sensor sensor) {
    return modelMapper.map(sensor, SensorDto.class);
  }

  public Sensor convertToEntity(SensorDto sensorDto) {
    return modelMapper.map(sensorDto, Sensor.class);
  }
}
