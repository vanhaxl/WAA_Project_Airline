package cs545.airline.beans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AirlineDetailBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private AirlineBean airlineBean;

    @Inject
    AirlineService airlineService;

    private Airline airline;

    public Airline getAirline() {
        return airline;
    }

    public void onload() {
        airline = airlineBean.hasAirline() ? airlineBean.getCurrentAirline() : new Airline();
    }

    public String submit() {
        System.out.println("ha: in submit function");
         airlineService.create(airline);
        return "airlines";
    }
}
