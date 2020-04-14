package sci.project.TransportantionCompany.service.busTicket;

import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.BusTicket;

@Service
public interface BusTicketService {

    void addBusTicket(BusTicket busTicket);
}
