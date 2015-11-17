package restservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import restservice.databaseoperations.DatabaseOperations;
import restservice.entities.Animals;
import restservice.entities.User;

@Path("service")
public class ServiceMethods {
	
	DatabaseOperations dbOps = new DatabaseOperations();
	
	@GET
	@Path("animals")
	@Produces(MediaType.APPLICATION_JSON)
	public Animals getAnimals() {
		Animals animals = new Animals();
		animals.animals = dbOps.listAnimals();
				
		return animals;
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(User user) {
		return dbOps.login(user.getUsername(), user.getPassword());		
	}
}
