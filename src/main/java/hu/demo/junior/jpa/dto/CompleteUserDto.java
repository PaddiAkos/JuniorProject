package hu.demo.junior.jpa.dto;

import hu.demo.junior.jpa.model.Mobilapp;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompleteUserDto extends UserDto {

    @NotBlank
    private int age;

    private String name;

    private List<Mobilapp> mobilapps;

    private Mobilapp RunNow;


}
