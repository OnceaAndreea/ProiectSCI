package sci.project.TransportantionCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.service.BusRouteService;

import javax.validation.Valid;

@Controller
@RequestMapping("/routecontroller")
public class RouteController {

    @Autowired
    BusRouteService busRouteService;

    @ModelAttribute("busRoute")
    public BusRoute busRoute() {
        return new BusRoute();
    }

    @GetMapping("/home")
    public String showHomePageForm(BusRoute busRoute) {
        return "home-page";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String addPerson(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }

        model.addAttribute("busRoutes", busRouteService.getAllRoutes(busRoute.getDeparture(), busRoute.getArrival(), busRoute.getDepartureTime()));
        return "routes";
    }
}


