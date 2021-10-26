package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
public class MonitoredValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monitored_id")
    private Long id;
    private Date timestamp;
    private Double energyConsumption;
}
