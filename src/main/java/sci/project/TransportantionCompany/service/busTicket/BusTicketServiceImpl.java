package sci.project.TransportantionCompany.service.busTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.model.BusTicket;
import sci.project.TransportantionCompany.model.User;
import sci.project.TransportantionCompany.repository.BusRouteRepository;
import sci.project.TransportantionCompany.repository.BusTicketRepository;

@Component
public class BusTicketServiceImpl implements BusTicketService {

    @Autowired
    BusTicketRepository busTicketRepository;

    @Override
    public void addBusTicket(BusTicket busTicket) {

        busTicketRepository.save(busTicket);
    }
}
