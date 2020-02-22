package sci.project.TransportantionCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sci.project.TransportantionCompany.model.BusRoute;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute,Integer> {


}
