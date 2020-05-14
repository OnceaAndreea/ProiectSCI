package sci.project.TransportantionCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sci.project.TransportantionCompany.model.BusRoute;

@Controller
public class MainController {

    @ModelAttribute("busRoute")
    public BusRoute busRoute() {
        return new BusRoute();
    }

    @GetMapping("/")
    public String showHomePageForm() {
        return "home-page";
    }

    @GetMapping("/company")
    public String showCompanyPageForm() {
        return "company";
    }


}


