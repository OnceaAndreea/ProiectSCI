package sci.project.TransportantionCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.model.BusTicket;
import sci.project.TransportantionCompany.service.busRoute.BusRouteService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BusRouteController {

    @Autowired
    BusRouteService busRouteService;

    @ModelAttribute("busRoute")
    public BusRoute busRoute() {
        return new BusRoute();
    }

    @GetMapping("/addRoute")
    public String showAddRoutePage() {
        return "add-route";
    }

    @PostMapping(value = "/addRoute", params = "addNewBusRoute")
    public String addRoute(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "admin-page";
        }

        busRouteService.addBusRoute(busRoute);
        return "redirect:/addRoute?success";
    }

    @GetMapping("/editOrDelete")
    public String editOrDelete(@Valid BusRoute busRoute, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin-page";
        }
        List<BusRoute> testrute=busRouteService.getAll();
        System.out.println(testrute);
        model.addAttribute("busRoutes", busRouteService.getAll());
        return "edit-delete";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        BusRoute busRoute = busRouteService.findRouteById(id);
        model.addAttribute("busRoute", busRoute);
        return "update-route";
    }

    @PostMapping("/update/{id}")
    public String updateRoute(@PathVariable("id") int id, @Valid BusRoute busRoute,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            busRoute.setId(id);
            return "update-route";
        }

        busRouteService.addBusRoute(busRoute);
        model.addAttribute("busRoutes", busRouteService.getAll());
        return "edit-delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoute(@PathVariable("id") int id, Model model) {
        BusRoute busRoute = busRouteService.findRouteById(id);
        busRouteService.deleteRouteById(id);
        model.addAttribute("busRoutes", busRouteService.getAll());
        return "edit-delete";
    }

    @GetMapping(value = "/search", params = "searchBtn")
    public String searchRoute(@ModelAttribute("busRoute") @Valid BusRoute busRoute, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "home-page";
        }

        model.addAttribute("busRoutes", busRouteService.getAllRoutes(busRoute.getDeparture(), busRoute.getArrival(), busRoute.getDepartureDate()));
        return "routes";
    }


}
