package hu.demo.junior.jpa.service.impl;

import hu.demo.junior.jpa.dto.CompleteUserDto;
import hu.demo.junior.jpa.dto.UserDto;
import hu.demo.junior.jpa.model.Cuser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    List<CompleteUserDto> findAll();

    Cuser findById (Long Userid);

    void deleteUser(Long Userid);

    void createUser(UserDto createUser);

    void updatePerson(UserDto userDto, Long Userid);


}
