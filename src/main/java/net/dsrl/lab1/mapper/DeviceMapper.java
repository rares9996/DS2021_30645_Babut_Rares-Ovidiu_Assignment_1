package net.dsrl.lab1.mapper;

import net.dsrl.lab1.model.Device;
import net.dsrl.lab1.model.dto.DeviceDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper {
    private final ModelMapper modelMapper;

    public DeviceMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DeviceDto convertToDto(Device device) {
        return modelMapper.map(device, DeviceDto.class);
    }

    public Device convertToEntity(DeviceDto deviceDto) {
        return modelMapper.map(deviceDto, Device.class);
    }
}
