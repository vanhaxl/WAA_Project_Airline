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

    private Airline airline;

    public Airline getAirline() {
        return airline;
    }

    public void onload() {
        if(airlineBean.getCurrentAirline() == null){
            this.airline = new Airline();
        } else{
            this.airline = airlineBean.getCurrentAirline();
        }

    }

    public String submit() {
        System.out.println("ha: in submit function");
         airlineBean.save(airline);
        return "airlines";
    }
}
