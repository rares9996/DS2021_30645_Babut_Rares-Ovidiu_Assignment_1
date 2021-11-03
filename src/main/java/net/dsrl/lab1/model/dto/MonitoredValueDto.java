package net.dsrl.lab1.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
public class MonitoredValueDto {

    private LocalDateTime timestamp;
    private Double energyConsumption;
}
