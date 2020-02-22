package sci.project.TransportantionCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sci.project.TransportantionCompany.model.Bus;
import sci.project.TransportantionCompany.repository.BusRepository;

import java.util.List;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;

    public void createBus(Bus bus){
        busRepository.save(bus);
    }
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus getBusById(int id)
    {
        return busRepository.findById(id).orElse(null);
    }

}
