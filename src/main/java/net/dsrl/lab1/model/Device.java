package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long id;
    private String description;
    private String address;
    @Column(name = "maximum_energy_consumption")
    private Double maximumEnergyConsumption;
    @Column(name = "average_energy_consumption")
    private Double averageEnergyConsumption;
    @OneToOne(targetEntity = Sensor.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor = new Sensor();


}
