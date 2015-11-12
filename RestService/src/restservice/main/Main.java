package restservice.main;

import restservice.databaseoperations.DatabaseOperations;

public class Main {

	public static void main(String[] args) {
		DatabaseOperations dbOp = new DatabaseOperations();
		
		//dbOp.insertUser("Jani", "12345", "N");
		dbOp.listAnimals();
		
		//dbOp.insertAnimal("1", "1", "1", 1, "1", 1, 1, "1", "1", "1", "1", "1");
		//dbOp.deleteAnimal(7);	
	}
}
