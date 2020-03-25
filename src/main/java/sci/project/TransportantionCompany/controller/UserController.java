package sci.project.TransportantionCompany.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.service.user.UserService;

@Controller("/userController")
public class UserController {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        System.out.println(" showRegistrationForm");
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") User user,
                                      BindingResult result) {

        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        System.out.println(" registerUserAccount");
        if (result.hasErrors()) {
            return "registration";
        }
        try {
            userService.save(user);
        } catch (Exception e) {
            // log something
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("partea de login");
        return "login";
    }
}
