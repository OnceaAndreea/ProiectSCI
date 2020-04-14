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

    public List<BusRoute> getAllRoutes(String departure, String arrival, String departureDate) {

        List<BusRoute> routes = new ArrayList<>();
        List<BusRoute> allRoutes = busRouteRepository.findAll();

        for (int i = 0; i < allRoutes.size(); i++) {
            if (allRoutes.get(i).getDeparture().equals(departure) && allRoutes.get(i).getArrival().equals(arrival) && allRoutes.get(i).getDepartureDate().equals(departureDate))
                routes.add(allRoutes.get(i));
        }

        Collections.sort(routes);

        return routes;
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



}
