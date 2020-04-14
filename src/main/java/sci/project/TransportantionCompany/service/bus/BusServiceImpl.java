package sci.project.TransportantionCompany.service.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.model.BusRoute;
import sci.project.TransportantionCompany.repository.BusRepository;

import java.util.List;
import java.util.Optional;

@Component
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public void addBus(Bus bus) {
        busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus findBusById(String id) {
        return busRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBusById(String id) {
        Bus bus = busRepository.findById(id).orElse(null);
        if (bus != null) {
            busRepository.delete(bus);
        }
    }

}
