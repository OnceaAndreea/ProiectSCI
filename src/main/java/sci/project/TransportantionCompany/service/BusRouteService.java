package sci.project.TransportantionCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.repository.BusRouteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusRouteService {

    @Autowired
    BusRouteRepository busRouteRepository;

    public List<BusRoute> getAllRoutes(String departure, String arrival, String departureTime) {

        List<BusRoute> routes = new ArrayList<>();
        List<BusRoute> allRoutes = busRouteRepository.findAll();

        for (int i = 0; i < allRoutes.size(); i++) {
            if (allRoutes.get(i).getDeparture().equals(departure) && allRoutes.get(i).getArrival().equals(arrival) && allRoutes.get(i).getDepartureTime().equals(departureTime))
                routes.add(allRoutes.get(i));
        }

        return routes;
    }
    public List<BusRoute> showAllAvailableRoutes(){
        return busRouteRepository.findAll();
    }

}
