package sci.project.TransportantionCompany.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sci.project.TransportantionCompany.model.Role;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.repository.UserRepository;

import java.util.Arrays;
import java.util.Objects;

public class AdminCreator implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        User user=userRepository.findByEmail("admin@yahoo.com");

        if(Objects.isNull(user)) {
            user = new User();
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setEmail("admin@yahoo.com");
        user.setPassword(passwordEncoder.encode("transdor"));
        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        userRepository.save(user);
    }}
}
