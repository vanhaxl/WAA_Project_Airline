package edu.mum.cs545.ws;

import javax.inject.Named;
import javax.ws.rs.*;

@Named
@Path("test")
public class TestRest {

    @GET
    @Path("hello")
    @Produces("application/json")
    public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
        String a = "";
        System.out.println("============================ASDASDASD========================");
        return "Hello REST " + name + "--------------";

    }

}
