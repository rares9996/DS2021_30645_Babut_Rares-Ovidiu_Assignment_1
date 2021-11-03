package net.dsrl.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;
import net.dsrl.lab1.model.Sensor;

@Setter
@Getter
public class DeviceDto {

  private Long id;
  private String description;
  private String address;
  private Double maximumEnergyConsumption;
  private Double averageEnergyConsumption;
  private Sensor sensor = new Sensor();

  @Override
  public String toString()
  {
    return this.id+" "+this.description;
  }
}
