package restservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import restservice.databaseoperations.DatabaseOperations;
import restservice.entities.Animal;

@Path("Service")
public class ServiceMethods {
	
	DatabaseOperations dbOps = new DatabaseOperations();
	
	@GET
	@Path("animals")
	//@Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	public String getAnimals() {	
		//return dbOps.listAnimals().get(0);
		return "a";
	}
}
