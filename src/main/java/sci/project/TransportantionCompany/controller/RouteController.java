package sci.project.TransportantionCompany.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
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

//    @RequestMapping(value = "/")
//    public String home() {
//        return "index";
//    }
//
//    @RequestMapping(value = "/", params = "showAll", method = RequestMethod.GET)
//    public String homeShowAll(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {
//        if (!result.hasErrors()) {
//            if("showAll" != null)
//            model.addAttribute("busRoutes", busRouteService.showAllAvailableRoutes());
//        }
//        return "index";
//    }

    @GetMapping("/home")
    public String showHomePageForm(BusRoute busRoute) {
        return "home-page";
    }

    @RequestMapping(value = "/search", params = "searchBtn", method = RequestMethod.GET)
    public String addPerson(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }
        model.addAttribute("busRoutes", busRouteService.getAllRoutes(busRoute.getDeparture(), busRoute.getArrival(), busRoute.getDepartureDate()));
        return "routes";
    }

    @RequestMapping(value = "/search", params = "showAllDAndA", method = RequestMethod.GET)
    public String searchByDepartureAndArrival(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }

        model.addAttribute("busRoutes", busRouteService.getAllByDepartureAndArrival(busRoute.getDeparture(), busRoute.getArrival()));
        return "routes";
    }

    @RequestMapping(value = "/search", params = "showAllDepartureDay", method = RequestMethod.GET)
    public String searchByDate(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }

        model.addAttribute("busRoutes", busRouteService.getAllByDate(busRoute.getDepartureDate()));
        return "routes";
    }


    @RequestMapping(value = "/search", params = "showAll", method = RequestMethod.GET)
    public String searchAll(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }

        model.addAttribute("busRoutes", busRouteService.showAllAvailableRoutes());
        return "routes";
    }

    @RequestMapping(value = "/search", params = "backBtn", method = RequestMethod.GET)
    public String back(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result) {
        return "home-page";
    }


}


