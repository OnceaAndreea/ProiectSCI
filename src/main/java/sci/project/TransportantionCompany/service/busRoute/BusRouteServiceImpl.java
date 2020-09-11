package sci.project.TransportantionCompany.service.busRoute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.repository.BusRouteRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BusRouteServiceImpl implements BusRouteService {

    @Autowired
    BusRouteRepository busRouteRepository;

    public void addBusRoute(BusRoute busRoute) {
        busRoute.setNumberOfAvailableTickets(busRoute.getBus().getNumberOfSeats());
        busRouteRepository.save(busRoute);
        busRoute.getBus().assignRouteToBus(busRoute);
    }

    public List<BusRoute> getAll() {
        return busRouteRepository.findAll();
    }

    public List<BusRoute> getMatchingRoutes(String departure, String arrival, String departureDate) {

        List<BusRoute> matchingRoutes = new ArrayList<>();
        List<BusRoute> allRoutes = busRouteRepository.findAll();

        for (int i = 0; i < allRoutes.size(); i++) {
            if (allRoutes.get(i).getDeparture().equalsIgnoreCase(departure) && allRoutes.get(i).getArrival().equalsIgnoreCase(arrival) && allRoutes.get(i).getDepartureDate().equals(departureDate) && allRoutes.get(i).getNumberOfAvailableTickets()>0)
                matchingRoutes.add(allRoutes.get(i));
        }

        Collections.sort(matchingRoutes);

        return matchingRoutes;
    }

    public BusRoute findRouteById(int id) {
        return busRouteRepository.findById(id).orElse(null);
    }

    public void deleteRouteById(int id) {
        BusRoute busRoute = busRouteRepository.findById(id).orElse(null);
        if (busRoute != null) {
            busRouteRepository.delete(busRoute);
        }
    }

    @Override
    public void updateNumberOfAvailableTickets(int id, int quantity) {
        BusRoute busRoute=busRouteRepository.findById(id).orElse(null);
        busRoute.updateAvailableTickets(quantity);
    }


}
