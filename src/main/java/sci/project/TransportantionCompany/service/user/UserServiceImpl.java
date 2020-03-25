package sci.project.TransportantionCompany.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.Role;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles()
                .stream()
                .map(Role::getName)
                .toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    @Override
    public void save(User user) {
        userRepository.save(new User(user.getEmail(), passwordEncoder.encode(user.getPassword()), Collections.singletonList(new Role("USER"))));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

