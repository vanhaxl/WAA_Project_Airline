package edu.mum.cs545.ws;

import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Named
@Path("test")
public class TestRest {

    @GET
    public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
        String a = "";
        return "Hello REST " + name + "!";

    }

}
