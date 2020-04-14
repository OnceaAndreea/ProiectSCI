package sci.project.TransportantionCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sci.project.TransportantionCompany.model.BusTicket;

public interface BusTicketRepository extends JpaRepository<BusTicket,Integer> {

}
