package net.dsrl.lab1.model.dto;
import lombok.Getter;
import lombok.Setter;
import net.dsrl.lab1.model.Device;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
public class RegisterDto {
  private String name;
  private String address;
  private Date birthdayDate;
  private String username;
  private String password;
  private Set<String> roles;
  private Set<Device> devices;
}
