package net.dsrl.lab1.repository;

import net.dsrl.lab1.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepositoy extends JpaRepository<Device, Long> {

    @Query(value = "select d from Device d where d not in :devices")
    List<Device> getAllDevicesWithoutUsers(List<Device> devices);

    @Query(value = "select u.devices from User u")
    List<Device> getAllDevicesWithUser();

}
