package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.MonitoredValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoredValueRepository extends JpaRepository<MonitoredValue, Long> {
}
