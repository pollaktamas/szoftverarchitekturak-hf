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
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User regUser(User user) {
		boolean exists = dbOps.checkUserName(user.getUsername());
		
		if (!exists) {
			dbOps.insertUser(user.getUsername(), user.getPassword(), "N");
			return user;
		}
		
		return null;		
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
	@Path("rent")
	@Consumes(MediaType.APPLICATION_JSON)
	public void rent(UserAnimal ua) {	
		dbOps.rentAnimal(ua.u_id, ua.a_id);
	}
	
	// Ready.
	@POST
	@Path("bringBack")
	@Consumes(MediaType.APPLICATION_JSON)
	public void bringBackAnimal(Animal animal) {
		dbOps.bringBackAnimal(animal.getId());	
	}
	
	// Ready.
	@POST
	@Path("search")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Animals searchAnimal(Search so) {
		Animals a = new Animals();
		a.animals = dbOps.searchAnimals(so.species, so.breed, so.is_available, so.is_broken);
		return a;
	}
	
	@POST
	@Path("insertAnimal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertAnimal(Animal a) {
		dbOps.insertAnimal(a.getSpecies(), a.getBreed(), a.getSex(), a.getAge(), a.getColor(), a.getVolume(), a.getWeight(), a.getFavourite_meal(), a.getHobby(), a.getIs_available(), a.getIs_broken(), a.getPicture());
	}
	
	// Ready.
	@POST
	@Path("deleteAnimal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteAnimal(Animal a) {
		dbOps.deleteAnimal(a.getId());
	}
	
	// Ready.
	@POST
	@Path("updateAnimal")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAnimal(Animal a) {
		dbOps.updateAnimal(a.getId(), a.getSpecies(), a.getBreed(), a.getSex(), a.getAge(), a.getColor(), a.getVolume(), a.getWeight(), a.getFavourite_meal(), a.getHobby(), a.getIs_available(), a.getIs_broken(), a.getPicture());
	}
}
