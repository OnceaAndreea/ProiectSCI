package sci.project.TransportantionCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sci.project.TransportantionCompany.model.BusTicket;
import sci.project.TransportantionCompany.model.TicketDetails;

@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetails,Integer> {
}
