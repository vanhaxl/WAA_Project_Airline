package cs545.airline.beans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class AirlineBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @Inject
    AirlineService airlineService;

    private Airline currentAirline = null;

    public List<Airline> getAirlines(){
        return airlineService.findAll();
    }

    public Airline getCurrentAirline(){
        return this.currentAirline;
    }
    public String updateAirline(long id) {
        this.currentAirline = new Airline();
        this.currentAirline.setId(id);
        this.currentAirline = airlineService.find(currentAirline);
        return "airline-details";
    }

    public String deleteAirline(long id) {
        currentAirline = new Airline();
        currentAirline.setId(id);
        currentAirline = airlineService.find(currentAirline);
        if(currentAirline.getFlights().isEmpty()) {
            airlineService.delete(currentAirline);
        }
        return "airlines";
    }
    public String save(Airline airline) {
        airlineService.create(airline);
        return "airlineList";
    }



}
