package sci.project.TransportantionCompany.service.user;
import org.springframework.security.core.userdetails.UserDetailsService;
import sci.project.TransportantionCompany.model.User;

public interface UserService extends UserDetailsService{

    void save(User user);

    User findByEmail(String email);
}
