package sci.project.TransportantionCompany.service.ticketDetails;

import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.TicketDetails;

@Service
public interface TicketDetailsService {

    void addTicketDetails(TicketDetails ticketDetails);
}
