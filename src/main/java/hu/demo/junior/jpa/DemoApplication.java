package hu.demo.junior.jpa;

import hu.demo.junior.jpa.enums.Image;
import hu.demo.junior.jpa.enums.Wallpaper;
import hu.demo.junior.jpa.model.Cuser;
import hu.demo.junior.jpa.model.Mobilapp;
import hu.demo.junior.jpa.repository.MobilAppRepository;
import hu.demo.junior.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner run(UserRepository userRepository, MobilAppRepository mobilAppRepository, PasswordEncoder passwordEncoder) {
        return args -> {


            Cuser cuser1 = new Cuser();
            cuser1.setFirstName("Kakas");
            cuser1.setLastName("János");
            cuser1.setBirthDate(LocalDate.of(2020, 1, 1));
            cuser1.setEmail("kakasjanos@nemtudom.com");
            cuser1.setType(Image.Green);
            cuser1.setWallpaper(Wallpaper.Jinx);
            cuser1.setUsername("janos");
            cuser1.setPassword(passwordEncoder.encode("alma"));
            cuser1.setRole("ADMIN");
            userRepository.save(cuser1);


            log.trace("Random User");

            Random ry = new Random();
            Random rm = new Random();
            Random rd = new Random();
            int year = 1969 + ry.nextInt(2023 - 1969);
            int month = 1 + rm.nextInt(12);
            int day = 1 + rd.nextInt(31);

            if (month == 2 && day > 28) {
                day = day - 3;
            } else {
                if ((month % 2 == 0 && month != 8) && day == 31) {
                    day = day - 1;
                }
            }
            List<String> subjects = new ArrayList<>();
            subjects.add("Ottó");
            subjects.add("János");
            subjects.add("Dávid");
            subjects.add("Mónika");
            subjects.add("Oscar");

            Random randomizer = new Random();
            String randomListElement = subjects.get(randomizer.nextInt(subjects.size()));
            String randomListElement2 = subjects.get(randomizer.nextInt(subjects.size()));

            Cuser Random = new Cuser();
            Random.setFirstName(String.valueOf(randomListElement));
            Random.setLastName(String.valueOf(randomListElement2));
            Random.setBirthDate(LocalDate.of(year, month, day));
            Random.setEmail("randomuser@nemtudom.com");
            Random.setWallpaper(Wallpaper.Dragon);
            Random.setUsername("Random");
            Random.setPassword(passwordEncoder.encode("valami"));
            Random.setRole("User");
            Random.setType(Image.Red);

            userRepository.save(Random);

            log.trace("MobilApps");

            Mobilapp mobilApps = new Mobilapp();
            mobilApps.setAgeLimit(10);
            mobilApps.setName("World of warcraft");

            Mobilapp mobilApps2 = new Mobilapp();
            mobilApps2.setAgeLimit(18);
            mobilApps2.setName("Mortal");

            Mobilapp mobilApps3 = new Mobilapp();
            mobilApps3.setAgeLimit(0);
            mobilApps3.setName("Cook Training");

            List<Mobilapp> Cuser1 = new ArrayList<>();
            Cuser1.add(mobilApps);
            Cuser1.add(mobilApps2);


            userRepository.save(Random);

            Cuser user1 = new Cuser();
            user1.setFirstName("Kakas");
            user1.setLastName("István");
            user1.setBirthDate(LocalDate.of(1990, 1, 1));
            user1.setEmail("kakasistvan@nemtudom.com");
            user1.setType(Image.Red);
            user1.setRunNow(mobilApps2);
            user1.setWallpaper(Wallpaper.Car);
            user1.setMobilapps(Cuser1);
            user1.setUsername("istvan");
            user1.setPassword(passwordEncoder.encode("valami"));
            user1.setRole("User");
            userRepository.save(user1);
            mobilAppRepository.save(mobilApps3);
            mobilAppRepository.save(mobilApps2);


        };
    }
}
