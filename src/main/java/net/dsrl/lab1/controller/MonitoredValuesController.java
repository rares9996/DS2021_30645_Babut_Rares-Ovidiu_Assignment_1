package net.dsrl.lab1.controller;

import net.dsrl.lab1.mapper.MonitoredValueMapper;
import net.dsrl.lab1.model.dto.MonitoredValueDto;
import net.dsrl.lab1.service.MonitoredValueService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/monitored-values")
public class MonitoredValuesController {

  private final MonitoredValueService monitoredValueService;
  private final MonitoredValueMapper monitoredValueMapper;

  public MonitoredValuesController(
      MonitoredValueService monitoredValueService, MonitoredValueMapper monitoredValueMapper) {
    this.monitoredValueService = monitoredValueService;
    this.monitoredValueMapper = monitoredValueMapper;
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<MonitoredValueDto>> getDevicesOfUser(
      @Valid @PathVariable String username) {
    return ResponseEntity.ok(
        monitoredValueService.getMonitoredValuesOfTodayForUser(username).stream()
            .map((monitoredValueMapper::convertToDto))
            .collect(Collectors.toList()));
  }
}
