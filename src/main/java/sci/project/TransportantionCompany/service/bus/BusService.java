package sci.project.TransportantionCompany.service.bus;

import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.Bus;

import java.util.List;
import java.util.Optional;

@Service
public interface BusService {

   void addBus(Bus bus);

   List<Bus> getAllBuses();

   Bus findBusById(String id);

   void deleteBusById(String id);

}
