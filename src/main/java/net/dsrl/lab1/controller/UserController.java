package net.dsrl.lab1.controller;

import net.dsrl.lab1.mapper.UserMapper;
import net.dsrl.lab1.model.dto.UserDto;
import net.dsrl.lab1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/user")
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(
        userService.getAllUsers().stream()
            .map((userMapper::convertToDto))
            .collect(Collectors.toList()));
  }

  @GetMapping("/{username}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<UserDto> getAllUsers(@PathVariable String username) {
    return ResponseEntity.ok(userMapper.convertToDto(userService.getUserByUsername(username)));
  }

  @PutMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
    return ResponseEntity.ok(userMapper.convertToDto(userService.updateUser(userDto)));
  }

  @DeleteMapping("/{username}")
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<Void> deleteUser(@PathVariable String username) {
    userService.deleteUser(username);
    return ResponseEntity.noContent().build();
  }
}
