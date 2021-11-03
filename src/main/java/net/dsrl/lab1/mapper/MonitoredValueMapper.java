package net.dsrl.lab1.mapper;

import net.dsrl.lab1.model.MonitoredValue;
import net.dsrl.lab1.model.Sensor;
import net.dsrl.lab1.model.dto.MonitoredValueDto;
import net.dsrl.lab1.model.dto.SensorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.management.monitor.Monitor;

@Component
public class MonitoredValueMapper {
  private final ModelMapper modelMapper;

  public MonitoredValueMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public MonitoredValueDto convertToDto(MonitoredValue monitoredValue) {
    return modelMapper.map(monitoredValue, MonitoredValueDto.class);
  }

  public MonitoredValue convertToEntity(MonitoredValueDto monitoredValueDto) {
    return modelMapper.map(monitoredValueDto, MonitoredValue.class);
  }
}
