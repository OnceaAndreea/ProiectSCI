package sci.project.TransportantionCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sci.project.TransportantionCompany.model.*;
import sci.project.TransportantionCompany.service.busRoute.BusRouteService;
import sci.project.TransportantionCompany.service.busTicket.BusTicketService;
import sci.project.TransportantionCompany.service.ticketDetails.TicketDetailsService;
import sci.project.TransportantionCompany.service.user.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class BusTicketController {

    @Autowired
    UserService userService;

    @Autowired
    BusTicketService busTicketService;

    @Autowired
    BusRouteService busRouteService;

    @Autowired
    TicketDetailsService ticketDetailsService;

    @ModelAttribute("ticketDetails")
    public TicketDetails ticketDetails() {
        return new TicketDetails();
    }

    @GetMapping("/buy/{id}")
    public String showBuyTicketForm(@PathVariable("id") int id, Model model) {
        BusRoute busRoute = busRouteService.findRouteById(id);

        model.addAttribute("busRoute", busRoute);
        return "buy-ticket";
    }

    @PostMapping("/buy")
    public String buyTicket(@ModelAttribute("busRoute") @Valid BusRoute busRoute,
                            @ModelAttribute("ticketDetails") @Valid TicketDetails ticketDetails,
                            BindingResult result, Model model, Principal principal) {

        if (ticketDetails.getQuantity() > busRoute.getNumberOfAvailableTickets()) {

            result.rejectValue("quantity", "error", "Only "+busRoute.getNumberOfAvailableTickets()+" available seats left!");
        }

        if(ticketDetails.getQuantity()<=0) {
            result.rejectValue("quantity","error", "Please provide a valid number");
        }

        if (ticketDetails.getQuantity() != (int)ticketDetails.getQuantity())
            result.rejectValue("quantity","error", "Please provide a valid number");

        if (result.hasErrors())
            return "buy-ticket";

        User user = userService.findByEmail(principal.getName());
        BusTicket busTicket = new BusTicket(busRoute.getDeparture(), busRoute.getDepartureStation(), busRoute.getArrival(), busRoute.getArrivalStation(), busRoute.getDepartureDate(), busRoute.getDepartureTime(), busRoute.getArrivalTime(), busRoute.getDistance(), busRoute.getPrice(), user);
        busTicketService.addBusTicket(busTicket);
        busRouteService.updateNumberOfAvailableTickets(busRoute.getId(), ticketDetails.getQuantity());

        double totalPrice = ticketDetails.getQuantity() * busRoute.getPrice();
        ticketDetails.setTotal(totalPrice);
        ticketDetails.setBusTicket(busTicket);
        ticketDetailsService.addTicketDetails(ticketDetails);
        busTicket.setDetails(ticketDetails);
        user.assignTicketToUser(busTicket);

        return "test";
    }

}
