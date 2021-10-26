package net.dsrl.lab1.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.dsrl.lab1.model.Device;
import net.dsrl.lab1.model.Role;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
public class UserDto {
  private Long id;
  private String name;
  private String address;
  private Date birthdayDate;
  private String username;
  private Set<Role> roles;
  private Set<Device> devices;
}
