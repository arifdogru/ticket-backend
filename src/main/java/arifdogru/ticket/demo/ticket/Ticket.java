package arifdogru.ticket.demo.ticket;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Arif
 * This is the entity class
 * Used for ticket
 */

@Entity
@Table(appliesTo = "ticket")
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    private String airPort;  // SAW Primary Key
    private String city;
    private String country;

    public Ticket(Long id, String airPort, String city, String country) {
        this.id = id;
        this.airPort = airPort;
        this.city = city;
        this.country = country;
    }

    public Ticket(){}

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", airPort='" + airPort + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirPort() {
        return airPort;
    }

    public void setAirPort(String airPort) {
        this.airPort = airPort;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
