package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.util.List;

@Named
@Path("airlines")
public class AirlineRest {
    @Inject
    private AirlineService airlineService;

    @GET
    public List<Airline> findAll(){
        return airlineService.findAll();
    }

    @Path("create")
    @POST
    public void create(Airline airline){
        airlineService.create(airline);
    }

    @Path("delete/{name}")
    @DELETE
    public void delete(@PathParam("name") String name){
        Airline airline = airlineService.findByName(name);
        airlineService.delete(airline);
    }

    @Path("delete")
    @DELETE
    public void deleteByJson(Airline airline){
        airlineService.delete(airline);
    }

    @Path("update")
    @PUT
    public Airline update(Airline airline){
        return airlineService.update(airline);
    }

    @Path("find")
    @POST
    public Airline find(Airline airline){
        return airlineService.find(airline);
    }

    @Path("findByName/{name}")
    @GET
    public Airline findByName(@PathParam("name") String name){
        return airlineService.findByName(name);
    }

    @Path("findByFlight")
    @POST
    public List<Airline> findByFlight(Flight flight){
        return airlineService.findByFlight(flight);
    }
}
