package net.dsrl.lab1.controller;

import net.dsrl.lab1.mapper.DeviceMapper;
import net.dsrl.lab1.model.dto.DeviceDto;
import net.dsrl.lab1.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/device")
public class DeviceController {

  private final DeviceService deviceService;
  private final DeviceMapper deviceMapper;

  public DeviceController(DeviceService deviceService, DeviceMapper deviceMapper) {
    this.deviceService = deviceService;
    this.deviceMapper = deviceMapper;
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<List<DeviceDto>> getAllDevices() {
    return ResponseEntity.ok(deviceService.getAll().stream()
        .map((deviceMapper::convertToDto))
        .collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<DeviceDto> getDeviceById(@Valid @PathVariable Long id) {
    return ResponseEntity.ok(deviceMapper.convertToDto(deviceService.getById(id)));
  }

  @PostMapping()
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<DeviceDto> createDevice(@Valid @RequestBody DeviceDto deviceDto) {
    return ResponseEntity.ok(deviceMapper.convertToDto(deviceService.createDevice(deviceDto)));
  }

  @PutMapping()
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<DeviceDto> updateDevice(@Valid @RequestBody DeviceDto deviceDto) {
    return ResponseEntity.ok(deviceMapper.convertToDto(deviceService.updateDevice(deviceDto)));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
    deviceService.deleteDevice(id);
    return ResponseEntity.noContent().build();
  }
}
