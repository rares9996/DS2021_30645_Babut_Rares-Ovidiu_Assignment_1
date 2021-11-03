package net.dsrl.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;
import net.dsrl.lab1.model.MonitoredValue;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class SensorDto {

  private Long id;
  private String description;
  private Double maximumValue;
  private Set<MonitoredValue> monitoredValue = new HashSet<>();
}
