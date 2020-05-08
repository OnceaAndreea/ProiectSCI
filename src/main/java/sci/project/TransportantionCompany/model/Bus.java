package sci.project.TransportantionCompany.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "bus")
public class Bus {

    @Id
    @Column(name = "id", unique = true, columnDefinition = "VARCHAR(64)", nullable = false)
    private String id;

    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @OneToMany
            (
                    mappedBy = "bus",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true
            )
    private List<BusRoute> routes = new ArrayList<>();

    public Bus() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<BusRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<BusRoute> routes) {
        this.routes = routes;
    }

    public void assignRouteToBus(BusRoute busRoute) {
        this.routes.add(busRoute);
    }

    public List<BusRoute> getRoutesFromGivenDate(String date) {

        List<BusRoute> matchingRoutes = new ArrayList<>();

        for (int i = 0; i < this.getRoutes().size(); i++)
            if (this.getRoutes().get(i).getDepartureDate().equals(date))
                matchingRoutes.add(this.getRoutes().get(i));

        Collections.sort(matchingRoutes);

       return matchingRoutes;

    }

}
