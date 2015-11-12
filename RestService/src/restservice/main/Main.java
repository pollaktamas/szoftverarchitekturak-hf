package restservice.main;

import java.util.List;

import restservice.databaseoperations.DatabaseOperations;
import restservice.entities.Animal;

public class Main {

	public static void main(String[] args) {
		DatabaseOperations dbOp = new DatabaseOperations();
		
		//dbOp.insertUser("Jani", "12345", "N");
		List<Animal> animals = dbOp.listAnimals();
		for (Animal animal: animals) {
			System.out.println(animal);
		}
		
		//dbOp.insertAnimal("1", "1", "1", 1, "1", 1, 1, "1", "1", "1", "1", "1");
		//dbOp.deleteAnimal(7);	
		
		//dbOp.rentAnimal(4, 1);
		
		//dbOp.bringBackAnimal(3);
		
		//User user = dbOp.login("bela", "bela123");
		//System.out.println(user);
	
		//User user = dbOp.login("nincsilyenuser", "blbl");
		//System.out.println(user);
		
		List<Animal> search = dbOp.searchAnimals("e", "e", "Y", "N");
		for (Animal animal: search) {
			System.out.println(animal);
		}
		
		//dbOp.updateAnimal(8, "2", "2", "1", 1, "1", 1, 1, "1", "1", "1", "1", "1");
	}
}
