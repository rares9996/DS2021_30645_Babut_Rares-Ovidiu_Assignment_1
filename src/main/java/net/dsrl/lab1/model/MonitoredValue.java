package net.dsrl.lab1.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "monitored_value")
public class MonitoredValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monitored_id")
    private Long id;
    private LocalDateTime timestamp;
    private Double energyConsumption;
}
