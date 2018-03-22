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

    private Airline currentAirline;

    public List<Airline> getAirlines(){
        return airlineService.findAll();
    }
    public Airline getCurrentAirline(){
        return this.currentAirline;
    }

    public String save(Airline airline) {
        airlineService.create(airline);
        return "airlineList";
    }
    public String finishDelete(){
        return "finished";
    }

}

