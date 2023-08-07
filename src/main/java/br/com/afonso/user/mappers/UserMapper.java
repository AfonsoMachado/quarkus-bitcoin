package br.com.afonso.user.mappers;

import br.com.afonso.user.dto.CreateUserDto;
import br.com.afonso.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    User toEntity(CreateUserDto certificationDto);

}
