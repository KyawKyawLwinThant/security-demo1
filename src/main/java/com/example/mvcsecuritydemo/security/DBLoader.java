package com.example.mvcsecuritydemo.security;

import com.example.mvcsecuritydemo.domain.Roles;
import com.example.mvcsecuritydemo.domain.User;
import com.example.mvcsecuritydemo.repository.RoleRepository;
import com.example.mvcsecuritydemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DBLoader implements CommandLineRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public DBLoader(BCryptPasswordEncoder bCryptPasswordEncoder,
                    UserRepository userRepository,
                    RoleRepository roleRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
    }

    @Override @Transactional
    public void run(String... args) throws Exception {
        Roles admin=new Roles();
        admin.setName("ROLE_ADMIN");
        Roles user=new Roles();
        user.setName("ROLE_USER");

        User adminUser=new User();
        adminUser.setEmail("kyaw@gmail.com");
        adminUser.setPassword(bCryptPasswordEncoder.encode("kyaw"));

        User userUser=new User();
        userUser.setEmail("thaw@gmail.com");
        userUser.setPassword(bCryptPasswordEncoder.encode("thaw"));

        //mapping
        adminUser.getRoles().add(admin);
        adminUser.getRoles().add(user);

        userUser.getRoles().add(user);

       // userRepository.save(adminUser);
        //userRepository.save(userUser);
    }
}
