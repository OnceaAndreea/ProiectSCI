package sci.project.TransportantionCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;

import java.util.List;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute,Integer> {

    List<BusRoute> getAllByDepartureAndArrival(String departure,String arrival);
    List<BusRoute> getAllByDepartureDate(String date);

}
