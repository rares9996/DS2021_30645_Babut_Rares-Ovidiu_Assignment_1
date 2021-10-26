package net.dsrl.lab1.mapper;

import net.dsrl.lab1.model.User;
import net.dsrl.lab1.model.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
  private final ModelMapper modelMapper;

  public UserMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public UserDto convertToDto(User user) {
    return modelMapper.map(user, UserDto.class);
  }

  public User convertToEntity(UserDto userDto) {
    return modelMapper.map(userDto, User.class);
  }
}
