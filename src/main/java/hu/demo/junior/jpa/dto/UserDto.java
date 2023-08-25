package hu.demo.junior.jpa.dto;

import hu.demo.junior.jpa.enums.Image;
import hu.demo.junior.jpa.enums.Wallpaper;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserDto {

    @Column(name = "email")
    private String email;


    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "type")
    private Image type;

    @Column(name = "wallpaper")
    private Wallpaper wallpaper;


}
