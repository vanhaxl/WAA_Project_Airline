package cs545.airline.beans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Named
@SessionScoped
public class AirlineDetailBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AirlineBean airlineBean;
    @Inject
    private AirlineService airlineService;

    private Airline airline;
   // @NotNull(message="enter something")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airline getAirline() {
        return airline;
    }

    public void onload() {
        if(airlineBean.getCurrentAirline() == null){
            airline = new Airline();
        } else{
            airline = airlineBean.getCurrentAirline();
            name = airlineBean.getCurrentAirline().getName();
        }
    }

    public String updateAirline(long id) {
        airline = new Airline();
        airline.setId(id);
        airline = airlineService.find(airline);
        this.name = airline.getName();
        return "airline-details";
    }

    public String createAirline(){
        airline =  new Airline();
        this.name = "";
        return "airline-details";
    }

    public String submit() {
        airline.setName(name);
        airlineBean.save(airline);

        return "airlines";
    }
}
