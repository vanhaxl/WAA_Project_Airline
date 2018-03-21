package cs545.airline.beans;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;
import javafx.util.Pair;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class FlightBean implements Serializable {

    @Inject
    FlightService flightService;

    @Inject
    AirlineService airlineService;

    @Inject
    AirportService airportService;

    @Inject
    AirplaneService airplaneService;

    @PostConstruct
    public void init() {
        search();
    }

    private String filterType = "all";

    public void setFilterType(String s) {
        filterType = s;
    }

    public String getFilterType() {
        return filterType;
    }

    public boolean checkFilterType(String s) {
        return filterType.equals(s);
    }

    private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

    private String flightnr;
    private long airlineId;
    private long airportId;
    private long destAirportId;
    private long airplaneId;
    private Date departmentDate;
    private Date arrivalDate;

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }


    public Date getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(Date departmentDate) {
        this.departmentDate = departmentDate;
    }

    public long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public long getDestAirportId() {
        return destAirportId;
    }

    public void setDestAirportId(long destAirportId) {
        this.destAirportId = destAirportId;
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
        this.airportId = airportId;
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }


    private List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Airline> getAirlines() {
        return airlineService.findAll();
    }

    public List<Airport> getAirports() {
        return airportService.findAll();
    }

    public List<Airplane> getAirplanes() {
        return airplaneService.findAll();
    }

    public String search() {
        switch (filterType) {
            case "flightnr":
                flights = flightService.findByNumber(flightnr);
                break;
            case "departureDateTime":
                flights = flightService.findByDeparture(departmentDate);
                break;
            case "arrivalDateTime":
                flights = flightService.findByDeparture(arrivalDate);
                break;
            case "airline":
                Airline airline = new Airline();
                airline.setId(airlineId);
                flights = flightService.findByAirline(airline);
                break;
            case "origin":
                Airport airport = new Airport();
                airport.setId(airportId);
                flights = flightService.findByOrigin(airport);
                break;
            case "destination":
                Airport airport1 = new Airport();
                airport1.setId(destAirportId);
                flights = flightService.findByDestination(airport1);
                break;
            case "airplane":
                Airplane airplane = new Airplane();
                airplane.setId(airplaneId);
                flights = flightService.findByAirplane(airplane);
                break;
            default:
                flights = flightService.findAll();
                break;
        }
        return "flights";
    }

    public List<Pair<String, String>> getFilterTypes() {
        List<Pair<String, String>> types = new ArrayList<>();
        types.add(new Pair<>("All", "all"));
        types.add(new Pair<>("Flight Number", "flightnr"));
        types.add(new Pair<>("Departure", "departureDateTime"));
        types.add(new Pair<>("Arrival", "arrivalDateTime"));
        types.add(new Pair<>("Airline", "airline"));
        types.add(new Pair<>("Origin", "origin"));
        types.add(new Pair<>("Destination", "destination"));
        types.add(new Pair<>("Airplane", "airplane"));
        return types;
    }
}
