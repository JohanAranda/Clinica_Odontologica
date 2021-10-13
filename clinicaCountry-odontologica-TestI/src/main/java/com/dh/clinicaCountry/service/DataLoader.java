package com.dh.clinicaCountry.service;

import com.dh.clinicaCountry.model.AppUser;
import com.dh.clinicaCountry.model.AppUserRole;
import com.dh.clinicaCountry.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("Fernando", "Diaz", "FernandoD@gmail.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Nata", "Castro", "NataC@gmail.com", hashedPassword2, AppUserRole.USER));
    }
}
