package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepositoy extends JpaRepository<Device, Long> {
}
