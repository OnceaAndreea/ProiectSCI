package sci.project.TransportantionCompany.controller;

import sci.project.TransportantionCompany.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sci.project.TransportantionCompany.model.BusTicket;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.service.user.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDTO() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @GetMapping("/administration")
    public String showAdminPage() {
        return "admin-page";
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

    @GetMapping("/profile")
    public String showProfileForm(Principal principal, Model model) {

        User user = userService.findByEmail(principal.getName());
        model.addAttribute("currentUser", user);
        return "my-profile";
    }

    @GetMapping("/mytickets")
    public String showUserTicketsForm(Model model, Principal principal) {

        User user = userService.findByEmail(principal.getName());
        List<BusTicket> myTickets = user.getTickets();

        model.addAttribute("tickets", myTickets);
        return "my-tickets";
    }


}
