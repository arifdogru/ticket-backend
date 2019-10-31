package arifdogru.ticket.demo.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ITicketRepository extends JpaRepository<Ticket,Long> {

    /*@Query("SELECT t FROM Ticket t WHERE t.airPort = :airPort ")
    List<Ticket> findTicketByAirPort(@Param("airPort") String airPort);*/

    @Query("SELECT t FROM Ticket t where t.airPort= ?1 ")
    public List<Ticket> findTicketByAirPort(String airPort);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ticket t WHERE t.airPort= ?1")
    public void deleteTicketByAirPort(String airPort);

}
