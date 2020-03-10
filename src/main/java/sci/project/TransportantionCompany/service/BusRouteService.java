package sci.project.TransportantionCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.repository.BusRouteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusRouteService {

    @Autowired
    BusRouteRepository busRouteRepository;

    public List<BusRoute> getAllRoutes(String departure, String arrival, String departureDate) {

        List<BusRoute> routes = new ArrayList<>();
        List<BusRoute> allRoutes = busRouteRepository.findAll();

        for (int i = 0; i < allRoutes.size(); i++) {
            if (allRoutes.get(i).getDeparture().equals(departure) && allRoutes.get(i).getArrival().equals(arrival) && allRoutes.get(i).getDepartureDate().equals(departureDate))
                routes.add(allRoutes.get(i));
        }

        return routes;
    }
    public List<BusRoute> showAllAvailableRoutes(){
        return busRouteRepository.findAll();
    }

    public List<BusRoute> getAllByDepartureAndArrival(String departure, String arrival){
        return busRouteRepository.getAllByDepartureAndArrival(departure,arrival);
    }
    public List<BusRoute> getAllByDate(String date){
        return busRouteRepository.getAllByDepartureDate(date);
    }

}
