package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Named
@Path("flight")
@Produces("application/json")
public class FlightRest {

    private Date dateParserFromString(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
        return format.parse(date);
    }

    @Inject
    private FlightService flightService;

    @Path("update")
    @POST
    public Flight update(Flight flight) {
        return flightService.update(flight);
    }

    @Path("find/{id}")
    @GET
    public Flight find(@PathParam("id") long id) {
        Flight aa = new Flight();
        aa.setId(id);
        return flightService.find(aa);
    }

    @Path("findByNumber/{flightNumber}")
    @GET
    public List<Flight> findByNumber(@PathParam("flightNumber") String flightnr) {
        return flightService.findByNumber(flightnr);
    }

    @Path("findByAirline/{airlineId}")
    @GET
    public List<Flight> findByAirline(@PathParam("airlineId") long airlineId) {
        Airline airline = new Airline();
        airline.setId(airlineId);
        return flightService.findByAirline(airline);
    }

    @Path("findByOrigin/{airportId}")
    @GET
    public List<Flight> findByOrigin(@PathParam("airportId") long airportId) {
        Airport airport = new Airport();
        airport.setId(airportId);
        return flightService.findByOrigin(airport);
    }

    @Path("findByDestination/{airportId}")
    @GET
    public List<Flight> findByDestination(@PathParam("airportId") long airportId) {
        Airport airport = new Airport();
        airport.setId(airportId);
        return flightService.findByDestination(airport);
    }

    @Path("findByAirplane/{airplaneId}")
    @GET
    public List<Flight> findByAirplane(@PathParam("airplaneId") long airplaneId) {
        Airplane airplane = new Airplane();
        airplane.setId(airplaneId);
        return flightService.findByAirplane(airplane);
    }

    @Path("findByArrival/{date}")
    @GET
    public List<Flight> findByArrival(@PathParam("date") String datetime) throws ParseException {
        return flightService.findByArrival(dateParserFromString(datetime));
    }

    @Path("findByArrivalBetween/{fdate}/{tdate}")
    @GET
    public List<Flight> findByArrivalBetween(@PathParam("fdate") String datetimeFrom, @PathParam("tdate") String datetimeTo) throws ParseException {
        return flightService.findByArrivalBetween(dateParserFromString(datetimeFrom), dateParserFromString(datetimeTo));
    }

    @Path("findByDeparture/{date}")
    @GET
    public List<Flight> findByDeparture(@PathParam("date") String datetime) throws ParseException {
        return flightService.findByDeparture(dateParserFromString(datetime));
    }

    @Path("findByDepartureBetween/{fdate}/{tdate}")
    @GET
    public List<Flight> findByDepartureBetween(@PathParam("fdate") String datetimeFrom, @PathParam("tdate") String datetimeTo) throws ParseException {
        return flightService.findByDepartureBetween(dateParserFromString(datetimeFrom), dateParserFromString(datetimeTo));
    }

    @Path("findAll")
    @GET
    public List<Flight> findAll() {
        return flightService.findAll();
    }


}
