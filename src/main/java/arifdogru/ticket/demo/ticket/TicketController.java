package arifdogru.ticket.demo.ticket;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/***
 * @author Arif
 * This is the rest service
 * controller level
 *
 */

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class TicketController {

    @Autowired
    private ITicketRepository ticketRepository;

    //Find

    /**
     * URL /tickets
     * RequestMethod GET
     * @return List of all find op. results
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    //Save
    /**
     * URL /tickets
     * RequestMethod POST
     * @return Ticket is added
     */
    @PostMapping("/tickets")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Ticket newTicket(@RequestBody Ticket newTicket) {

        System.out.println("gelen ticket:"+newTicket);

        return ticketRepository.save(newTicket);
    }

    /**
     * URL /tickets/{id}
     * RequestMethod GET
     * @return A ticket of findbyid method
     */
    @GetMapping(value="/tickets/{id}")
    Ticket  findOne(@PathVariable Long id){
        return ticketRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id,""));
    }

    /**
     * URL /tickets/ports/{airPort}
     * RequestMethod GET
     * @return List of all findByAirport op. results
     */
    @RequestMapping(value = "/tickets/ports/{airPort}", method = RequestMethod.GET)
    List<Ticket>  findAll(@PathVariable String airPort){
        System.out.println("******** find by airport called *** ---> " + airPort );
        return ticketRepository.findTicketByAirPort(airPort);
    }

    /**
     * URL /tickets/{airPort}
     * @RequestMethod DELETE
     */
    @RequestMapping(value = "/tickets/{airPort}", method = RequestMethod.DELETE)
    void deleteByName(@PathVariable String airPort) {
        System.out.println("******** delete by airport called *** ---> " + airPort );
        ticketRepository.deleteTicketByAirPort(airPort);
    }




}
