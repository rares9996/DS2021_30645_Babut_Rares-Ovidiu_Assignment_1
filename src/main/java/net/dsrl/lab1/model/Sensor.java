package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long id;
    private String description;
    @Column(name = "maximum_value")
    private Double maximumValue;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sensor_monitor",
            joinColumns = @JoinColumn(name = "sensor_id"),
            inverseJoinColumns = @JoinColumn(name = "monitored_id"))
    private Set<MonitoredValue> monitoredValue = new HashSet<>();
}
