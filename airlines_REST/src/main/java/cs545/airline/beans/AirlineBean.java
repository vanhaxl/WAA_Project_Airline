package cs545.airline.beans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AirlineBean implements Serializable{
    private static final long serialVersionUID = 1L;

    @Inject
    AirlineService airlineService;

    private List<Airline> airlineList;

    @PostConstruct
    public void initialize(){
        airlineList = airlineService.findAll();
    }
    public List<Airline> getAirlineList(){
        return airlineList;
    }

}
