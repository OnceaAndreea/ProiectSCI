package sci.project.TransportantionCompany.service.busRoute;

import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.BusRoute;

import java.util.List;

@Service
public interface BusRouteService {

    void addBusRoute(BusRoute busRoute);

    List<BusRoute> getAll();

    List<BusRoute> getMatchingRoutes(String departure, String arrival, String departureDate);

    BusRoute findRouteById(int id);

    void deleteRouteById(int id);

    void updateNumberOfAvailableTickets(int id,int quantity);
}
