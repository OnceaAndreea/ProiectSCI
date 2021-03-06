package sci.project.TransportantionCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.service.bus.BusService;

import javax.validation.Valid;

@Controller
public class BusController {

    @Autowired
    BusService busService;

    @ModelAttribute("bus")
    public Bus busRoute() {
        return new Bus();
    }

    @GetMapping("/addBus")
    public String showAddBusPage() {
        return "add-bus";
    }

    @PostMapping(value = "/addBus", params = "addNewBus")
    public String addRoute(@ModelAttribute("bus") @Valid Bus bus, BindingResult result, Model model) {

        if (busService.findBusById(bus.getId()) != null) {
            result.rejectValue("id", "error", "The bus with this registration number has already been added!");
        }

        if (bus.getId().isEmpty()) {
            result.rejectValue("id", "error", "*Required");
        }

        if (bus.getNumberOfSeats()== 0) {
            result.rejectValue("numberOfSeats", "error", "*Required");
        }

        if (bus.getNumberOfSeats() < 48 && bus.getNumberOfSeats()!=0)
            result.rejectValue("numberOfSeats", "error", "TRANSDOR buses have a minimum of 48 seats");

        if (bus.getNumberOfSeats() > 52)
            result.rejectValue("numberOfSeats", "error", "TRANSDOR buses have a maximum of 52 seats");

        if (result.hasErrors()) {
            return "add-bus";
        }

        busService.addBus(bus);
        return "redirect:/addBus?success";
    }

    @GetMapping("/editOrDeleteBus")
    public String editOrDelete(@Valid Bus bus, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin-page";
        }
        model.addAttribute("buses", busService.getAllBuses());
        return "edit-delete-bus";
    }


    @GetMapping("/editBus/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Bus bus = busService.findBusById(id);
        model.addAttribute("bus", bus);
        return "update-bus";
    }

    @PostMapping("/updateBus/{id}")
    public String updateBus(@PathVariable("id") String id, @Valid Bus bus,
                            BindingResult result, Model model) {

        if (bus.getId().isEmpty()) {
            result.rejectValue("id", "error", "*Required");
        }

        if (bus.getNumberOfSeats()== 0) {
            result.rejectValue("numberOfSeats", "error", "*Required");
        }

        if (bus.getNumberOfSeats() < 48 && bus.getNumberOfSeats()!=0)
            result.rejectValue("numberOfSeats", "error", "TRANSDOR buses have a minimum of 48 seats");

        if (bus.getNumberOfSeats() > 52)
            result.rejectValue("numberOfSeats", "error", "TRANSDOR buses have a maximum of 52 seats");

        if (result.hasErrors()) {
            bus.setId(id);
            return "update-bus";
        }

        busService.addBus(bus);
        model.addAttribute("buses", busService.getAllBuses());
        return "edit-delete-bus";
    }

    @GetMapping("/deleteBus/{id}")
    public String deleteRoute(@PathVariable("id") String id, Model model) {
        Bus bus = busService.findBusById(id);
        busService.deleteBusById(id);
        model.addAttribute("buses", busService.getAllBuses());
        return "edit-delete-bus";
    }


}
