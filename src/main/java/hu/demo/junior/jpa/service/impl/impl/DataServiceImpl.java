package hu.demo.junior.jpa.service.impl.impl;

import hu.demo.junior.jpa.dto.CompleteUserDto;
import hu.demo.junior.jpa.dto.UserDto;
import hu.demo.junior.jpa.exception.EntityNotFoundException;
import hu.demo.junior.jpa.model.Cuser;
import hu.demo.junior.jpa.repository.UserRepository;
import hu.demo.junior.jpa.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DataServiceImpl implements UserService {


    private final UserRepository userRepository;

    public DataServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public int calculateAge(LocalDate birthDate) {

        log.trace("Age calculator");

        LocalDate moment = LocalDate.now();
        if ((birthDate != null) && (moment != null)) {
        }
        return Period.between(birthDate, moment).getYears();
    }

    @Override
    public List<CompleteUserDto> findAll() {

        log.trace("FindAll User");

        List<Cuser> userlist = userRepository.findAll();

        return userlist.stream()
                .map(user ->
                {
                    CompleteUserDto comp = new CompleteUserDto();
                    comp.setAge(calculateAge(user.getBirthDate()));
                    comp.setName(String.format("%s %s", user.getFirstName(), user.getLastName()));
                    comp.setType(user.getType());
                    comp.setWallpaper(user.getWallpaper());
                    comp.setRunNow(user.getRunNow());
                    comp.setMobilapps(user.getMobilapps());
                    comp.setEmail(user.getEmail());

                    return comp;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Cuser findById(Long Userid) {
        return userRepository.findById(Userid)
                .orElseThrow(() -> new EntityNotFoundException(Cuser.class, Map.of("UserId", Userid.toString())));
    }



    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteById(userid);
    }

    @Override
    public void createUser(UserDto userDto) {

        log.trace("Create team {}", userDto);

        Cuser user = new Cuser();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setEmail(userDto.getEmail());
        user.setType(userDto.getType());
        user.setWallpaper(userDto.getWallpaper());
        userRepository.save(user);

    }

    @Override
    public void updatePerson(UserDto userDto, Long Userid) {

        log.trace("Update User with id {}", Userid);

        Cuser user = findById(Userid);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setEmail(userDto.getEmail());
        user.setType(userDto.getType());
        user.setWallpaper(userDto.getWallpaper());
        userRepository.save(user);

    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return (UserDetails) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

