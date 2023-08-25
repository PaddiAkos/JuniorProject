package hu.demo.junior.jpa.model;

import hu.demo.junior.jpa.enums.Image;
import hu.demo.junior.jpa.enums.Wallpaper;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"User\"")
@ToString
@EqualsAndHashCode
public class Cuser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "type")
    private Image type;

    @Column(name = "wallpaper")
    private Wallpaper wallpaper;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    @OneToMany(targetEntity = Mobilapp.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "user_id")
    private List<Mobilapp> mobilapps;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MobilApp_id", referencedColumnName = "app_id")
    private Mobilapp RunNow;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if(role != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); //ROLE_ADMIN
        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled() {return true;}
}