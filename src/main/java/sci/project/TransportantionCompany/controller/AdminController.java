package sci.project.TransportantionCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @GetMapping("/administration")
    public String showAdminPage() {
        return "admin-page";
    }

}
