package hu.demo.junior.jpa.Congif;

import hu.demo.junior.jpa.enums.Image;
import hu.demo.junior.jpa.enums.Wallpaper;
import hu.demo.junior.jpa.model.Cuser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserConfig{

    @Bean
    public Cuser cuser() {
        Cuser cuser1 = new Cuser();
        cuser1.setFirstName("Kakas");
        cuser1.setLastName("János");
        cuser1.setBirthDate(LocalDate.of(2020, 1, 1));
        cuser1.setEmail("kakasjanos@nemtudom.com");
        cuser1.setType(Image.Green);
        cuser1.setWallpaper(Wallpaper.Jinx);


        return cuser1;
    }
}
