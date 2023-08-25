package hu.demo.junior.jpa.controller;

import hu.demo.junior.jpa.dto.CompleteUserDto;
import hu.demo.junior.jpa.dto.OrderResponse;
import hu.demo.junior.jpa.dto.UserDto;
import hu.demo.junior.jpa.model.Cuser;
import hu.demo.junior.jpa.repository.UserRepository;
import hu.demo.junior.jpa.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/f1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;


    @GetMapping("/AllUser")
    public ResponseEntity<List<CompleteUserDto>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cuser> getUserById(@PathVariable(name = "userId") Long UserId) {
        return ResponseEntity.ok(userService.findById(UserId));

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId") Long Userid) {
        userService.deleteUser(Userid);
        return ResponseEntity.ok().build();

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> CreateUser(@RequestBody @Valid UserDto createUser) {
        userService.createUser(createUser);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable(name = "userId") Long UserId) {
        userService.updatePerson(userDto, UserId);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation() {
        return userRepository.getJoinInformation();

    }
}