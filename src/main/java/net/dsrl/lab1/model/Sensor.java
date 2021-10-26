package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Setter
@Getter
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;
    private String description;
    @Column(name = "maximum_value")
    private Double maximumValue;
    @OneToOne(targetEntity = MonitoredValue.class)
    @JoinColumn(name = "monitored_id")
    private MonitoredValue monitoredValue = new MonitoredValue();
}
