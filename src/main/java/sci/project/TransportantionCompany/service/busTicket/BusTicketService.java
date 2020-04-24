package sci.project.TransportantionCompany.service.busTicket;

import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.BusTicket;
import sci.project.TransportantionCompany.model.User;

@Service
public interface BusTicketService {

    void addBusTicket(BusTicket busTicket);
}
