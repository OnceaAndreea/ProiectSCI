package sci.project.TransportantionCompany.model;

import javax.persistence.*;

@Entity(name="ticket_details")
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "total", nullable = false)
    private double total;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable=false)
    private BusTicket busTicket;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BusTicket getBusTicket() {
        return busTicket;
    }

    public void setBusTicket(BusTicket busTicket) {
        this.busTicket = busTicket;
    }
}
