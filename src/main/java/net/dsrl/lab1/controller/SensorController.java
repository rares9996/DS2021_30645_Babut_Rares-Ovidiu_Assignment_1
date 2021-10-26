package net.dsrl.lab1.controller;

import net.dsrl.lab1.mapper.SensorMapper;
import net.dsrl.lab1.model.dto.SensorDto;
import net.dsrl.lab1.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/sensor")
public class SensorController {

  private final SensorService sensorService;
  private final SensorMapper sensorMapper;

  public SensorController(SensorService sensorService, SensorMapper sensorMapper) {
    this.sensorService = sensorService;
    this.sensorMapper = sensorMapper;
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<List<SensorDto>> getAllSensors() {
    return ResponseEntity.ok(
        sensorService.getAll().stream()
            .map((sensorMapper::convertToDto))
            .collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<SensorDto> getSensorById(@Valid @PathVariable Long id) {
    return ResponseEntity.ok(sensorMapper.convertToDto(sensorService.getById(id)));
  }

  @PostMapping()
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<SensorDto> createDevice(@Valid @RequestBody SensorDto sensorDto) {
    return ResponseEntity.ok(sensorMapper.convertToDto(sensorService.createSensor(sensorDto)));
  }

  @PutMapping()
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<SensorDto> updateDevice(@Valid @RequestBody SensorDto sensorDto) {
    return ResponseEntity.ok(sensorMapper.convertToDto(sensorService.updateSensor(sensorDto)));
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
    sensorService.deleteSensor(id);
    return ResponseEntity.noContent().build();
  }
}
