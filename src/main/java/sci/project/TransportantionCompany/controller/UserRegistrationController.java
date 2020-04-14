package sci.project.TransportantionCompany.controller;

import dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.service.user.UserService;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDTO() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }


}
