package net.dsrl.lab1.service;

import net.dsrl.lab1.controller.handlers.exception.ResourceNotFoundException;
import net.dsrl.lab1.model.User;
import net.dsrl.lab1.model.dto.UserDto;
import net.dsrl.lab1.repository.DeviceRepositoy;
import net.dsrl.lab1.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final DeviceRepositoy deviceRepositoy;

  public UserService(UserRepository userRepository, DeviceRepositoy deviceRepositoy) {
    this.userRepository = userRepository;
    this.deviceRepositoy = deviceRepositoy;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByUsername(String username) {
    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new ResourceNotFoundException("User not found for username: " + username));
  }

  public User updateUser(UserDto userDto) {
    User user = getUserByUsername(userDto.getUsername());
    user.setAddress(userDto.getAddress());
    user.setUsername(userDto.getUsername());
    user.setDevices(userDto.getDevices());
    user.setName(userDto.getName());

    return userRepository.save(user);
  }

  @Transactional
  public void deleteUser(String username) {
    userRepository.deleteByUsername(username);
  }
}
