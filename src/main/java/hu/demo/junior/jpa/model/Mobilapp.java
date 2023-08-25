package hu.demo.junior.jpa.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Mobilapp")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Mobilapp  {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "app_id", nullable = false, unique = true)
        private Long appId;

        @NotBlank
        @Column(name = "name", nullable = false)
        private String Name;

        @Column(name = "AgeLimit")
        private int AgeLimit;


}
