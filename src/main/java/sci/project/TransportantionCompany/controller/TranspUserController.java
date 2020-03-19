package sci.project.TransportantionCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/transpUserController")
public class TranspUserController {

    @GetMapping("/register")
    public String showRegisterPageForm() {
        return "register-page";
    }
}
