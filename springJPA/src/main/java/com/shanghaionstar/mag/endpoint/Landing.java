package com.shanghaionstar.mag.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;


@Path("/Landing")
public interface Landing {
	
	@POST
	@Produces({MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_XML})
	@Path("Page{")
	String SaveLandingpage(String request);
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_XML})
	@Path("Page/{name}")
	String GetLandingpage(@PathParam("name") String request);
}
