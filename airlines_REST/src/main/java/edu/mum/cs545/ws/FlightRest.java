package edu.mum.cs545.ws;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Named
@Path("flight")
public class FlightRest {

    @Inject
    private FlightService flightService;

    @Path("find/{id}")
    @GET
    public Flight find(@PathParam("id") long id) {
        Flight aa = new Flight();
        aa.setId(id);
        return flightService.find(aa);
    }

}
