package net.dsrl.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;
import net.dsrl.lab1.model.MonitoredValue;

@Setter
@Getter
public class SensorDto {

  private Long id;
  private String description;
  private Double maximumValue;
  private MonitoredValue monitoredValue = new MonitoredValue();
}
