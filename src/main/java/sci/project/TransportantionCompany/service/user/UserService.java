package sci.project.TransportantionCompany.service.user;
import dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import sci.project.TransportantionCompany.model.User;

public interface UserService extends UserDetailsService{

    User save(UserRegistrationDto registeredUser);

    User findByEmail(String email);

}
