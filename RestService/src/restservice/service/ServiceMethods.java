package restservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import restservice.databaseoperations.DatabaseOperations;
import restservice.entities.Animal;
import restservice.entities.User;

@Path("service")
public class ServiceMethods {
	
	DatabaseOperations dbOps = new DatabaseOperations();
	
	// Ready.
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(User user) {
		return dbOps.login(user.getUsername(), user.getPassword());		
	}
	
	// Ready.
	@GET
	@Path("animals")
	@Produces(MediaType.APPLICATION_JSON)
	public Animals getAnimals() {
		Animals animals = new Animals();
		animals.animals = dbOps.listAnimals();
				
		return animals;
	}
	
	// Ready.
	@POST
	@Path("bringBack")
	@Consumes(MediaType.APPLICATION_JSON)
	public void bringBackAnimal(Animal animal) {
		dbOps.bringBackAnimal(animal.getId());	
	}
}
