package net.dsrl.lab1.service;

import net.dsrl.lab1.model.ERole;
import net.dsrl.lab1.model.Role;
import net.dsrl.lab1.model.User;
import net.dsrl.lab1.model.dto.RegisterDto;
import net.dsrl.lab1.model.dto.UserDto;
import net.dsrl.lab1.repository.RoleRepository;
import net.dsrl.lab1.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegisterService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder encoder;

  public RegisterService(
      UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.encoder = encoder;
  }

  public void registerUser(RegisterDto signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      throw new BadCredentialsException("Error: Username is already taken!");
    }

    User user =
        new User(
            signUpRequest.getName(),
            signUpRequest.getBirthdayDate(),
            signUpRequest.getAddress(),
            signUpRequest.getUsername(),
            encoder.encode(signUpRequest.getPassword()),
            signUpRequest.getDevices());

    Set<String> strRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole =
          roleRepository
              .findByName(ERole.USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(
          role -> {
            switch (role) {
              case "admin":
                Role adminRole =
                    roleRepository
                        .findByName(ERole.ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(adminRole);

                break;
              default:
                Role userRole =
                    roleRepository
                        .findByName(ERole.USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                roles.add(userRole);
            }
          });
    }

    user.setRoles(roles);
    userRepository.save(user);
  }
}
