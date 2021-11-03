package net.dsrl.lab1.service;

import net.dsrl.lab1.controller.handlers.exception.ResourceNotFoundException;
import net.dsrl.lab1.mapper.DeviceMapper;
import net.dsrl.lab1.model.Device;
import net.dsrl.lab1.model.User;
import net.dsrl.lab1.model.dto.DeviceDto;
import net.dsrl.lab1.repository.DeviceRepositoy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class DeviceService {

  private final DeviceRepositoy deviceRepositoy;
  private final DeviceMapper deviceMapper;
  private final UserService userService;

  public DeviceService(DeviceRepositoy deviceRepositoy, DeviceMapper deviceMapper, UserService userService) {
    this.deviceRepositoy = deviceRepositoy;
    this.deviceMapper = deviceMapper;
    this.userService = userService;
  }

  public List<Device> getAll() {
    return deviceRepositoy.findAll();
  }

  public Device getById(Long id) {
    return deviceRepositoy
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Device not found for id: " + id));
  }

  public Device createDevice(DeviceDto deviceDto) {
    Device device = deviceMapper.convertToEntity(deviceDto);
    return deviceRepositoy.save(device);
  }

  public Device updateDevice(DeviceDto deviceDto) {
    Device device = getById(deviceDto.getId());
    device.setAddress(deviceDto.getAddress());
    device.setDescription(deviceDto.getDescription());
    device.setSensor(deviceDto.getSensor());
    device.setAverageEnergyConsumption(deviceDto.getAverageEnergyConsumption());
    device.setMaximumEnergyConsumption(deviceDto.getMaximumEnergyConsumption());

    return deviceRepositoy.save(device);
  }

  @Transactional
  public void deleteDevice(Long id) {
    Device device = getById(id);
    device.setSensor(null);
    deviceRepositoy.save(device);
    deviceRepositoy.deleteById(id);
  }

  public List<Device> getDevicesWithoutUser()
  {
    return deviceRepositoy.getAllDevicesWithoutUsers(deviceRepositoy.getAllDevicesWithUser());
  }

  public Set<Device> getDeviceOfUser(String username)
  {
    User user = userService.getUserByUsername(username);
    return user.getDevices();
  }
}
