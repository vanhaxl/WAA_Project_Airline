package cs545.airline.delete;

import cs545.airline.beans.AirlineBean;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@FlowScoped("delete")
public class Delete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    AirlineService airlineService;

    @Inject
    AirlineBean airlineBean;

    private Airline currentAirline;

    public List<Airline> getAirlines(){
        return airlineService.findAll();
    }

    public Airline getCurrentAirline(){
        return this.currentAirline;
    }

//    public String deleteAirline(long id) {
//        currentAirline = new Airline();
//        currentAirline.setId(id);
//        currentAirline = airlineService.find(currentAirline);
//        if(currentAirline.getFlights().isEmpty()) {
//            airlineService.delete(currentAirline);
//            return "success";
//        }
//        return "failure";
//    }

    public String finishDelete(){
        return "finished";
    }
}
