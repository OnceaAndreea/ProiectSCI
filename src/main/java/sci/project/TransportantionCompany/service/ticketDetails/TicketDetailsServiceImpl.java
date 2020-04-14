package sci.project.TransportantionCompany.service.ticketDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sci.project.TransportantionCompany.model.TicketDetails;
import sci.project.TransportantionCompany.repository.TicketDetailsRepository;

@Component
public class TicketDetailsServiceImpl implements TicketDetailsService {

    @Autowired
    TicketDetailsRepository ticketDetailsRepository;

    @Override
    public void addTicketDetails(TicketDetails ticketDetails) {
        ticketDetailsRepository.save(ticketDetails);
    }
}
