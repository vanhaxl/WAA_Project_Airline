package edu.mum.cs545.ws;

import cs545.airline.model.Airplane;
import cs545.airline.model.Flight;
import cs545.airline.service.AirplaneService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.util.List;

@Named
@Path("airplanes")
public class AirplaneRest {
    @Inject
    private AirplaneService airplaneService;

    @GET
    public List<Airplane> findAll() {
        return airplaneService.findAll();
    }

    @Path("create")
    @POST
    public void create(Airplane airplane) {
        airplaneService.create(airplane);
    }

    @Path("delete/{serialNumber}")
    @DELETE
    public void delete(@PathParam("serialNumber") String serialNumber) {
        Airplane airplane = airplaneService.findBySrlnr(serialNumber);
        airplaneService.delete(airplane);
    }

    @Path("delete")
    @DELETE
    public void deleteByJson(Airplane airplane) {
        airplaneService.delete(airplane);
    }

    @Path("update")
    @PUT
    public Airplane update(Airplane airplane) {
        return airplaneService.update(airplane);
    }

    @Path("find")
    @POST
    public Airplane find(Airplane airplane) {
        return airplaneService.find(airplane);
    }

    @Path("findBySerialNumber/{serialNumber}")
    @GET
    public Airplane findBySerialNumber(@PathParam("serialNumber") String serialNumber) {
        return airplaneService.findBySrlnr(serialNumber);
    }

    @Path("findByFlight")
    @POST
    public List<Airplane> findByFlight(Flight flight) {
        return airplaneService.findByFlight(flight);
    }

    @Path("findByModel/{model}")
    @POST
    public List<Airplane> findByModel(@PathParam("model") String model) {
        return airplaneService.findByModel(model);
    }
}
