package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AirportRest {
	@Inject
	private AirportService airportService;

	// creating airport******************
	@Path("create")
	@POST
	public void create(Airport airport) {
		airportService.create(airport);
	}

	// deleting airport
	@Path("delete/{airportid}")
	@GET
	public void delete(@PathParam("airportid") long id) {
		Airport airport = new Airport();
		airport.setId(id);
		//Airport airport= airportService.
		airportService.delete(airport);
	}
	
	// update airport************************
	@Path("update")
	@PUT
	public Airport update(Airport airport) {
//		Airport airport = new Airport();
//		airport.setId(id);
		
		return airportService.update(airport);

	}

	// finding airport***************
	@Path("find/{airportid}")
	@GET
	public Airport find(@PathParam("airportid") long id) {
		Airport airport = new Airport();
		airport.setId(id);
		return airportService.find(airport);

	}

	// finding airport by code********
	@Path("bycode/{name}")
	@GET
	public Airport findByCode(@PathParam("name") String airportcode) {
		return airportService.findByCode(airportcode);

	}

	// find airports by arrival*******************
	@Path("byarrival/{flightid}")
	@GET
	public List<Airport> findByArrival(@PathParam("flightid") long id) {
		Flight flights= new Flight();
		flights.setId(id);
		return airportService.findByArrival(flights);

	}

	// find airports by departure************
	@Path("bydeparture/{flightid}")
	@GET
	public List<Airport> findByDeparture(@PathParam("flightid") long id) {
		Flight flight= new Flight();
		flight.setId(id);
		return airportService.findByDeparture(flight);

	}

	// find airports by city*********************
	@Path("bycity/{name}")
	@GET
	public List<Airport> findByCity(@PathParam("name") String city) {
		return airportService.findByCity(city);

	}

	// find airports by country*******************
	@Path("bycountry/{name}")
	@GET
	public List<Airport> findByCountry(@PathParam("name") String country) {
		return airportService.findByCountry(country);

	}

	// find airports by name *****************
	@Path("byname/{name}")
	@GET
	public List<Airport> findByName(@PathParam("name") String name) {

		return airportService.findByName(name);

	}

	// find all airports *****************
	@Path("all")
	@GET
	public List<Airport> findAll() {

		return airportService.findAll();

	}
}