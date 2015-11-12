package restservice.databaseoperations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import restservice.entities.Animal;
import restservice.entities.User;

public class DatabaseOperations {
	EntityManagerFactory emfactory;
    EntityManager entitymanager;
	
	public void insertUser(String username, String password, String is_admin) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setIs_admin(is_admin);

		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
		closeFactoryAndManager();
	}
	
	public void insertAnimal(String species, String breed, String sex, int age, String color, int volume, int weight, String favourite_meal,
			String hobby, String is_available, String is_broken, String picture) {
	
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Animal animal = new Animal();
		animal.setSpecies(species);
		animal.setBreed(breed);
		animal.setSex(sex);
		animal.setAge(age);
		animal.setColor(color);
		animal.setVolume(volume);
		animal.setWeight(weight);
		animal.setFavourite_meal(favourite_meal);
		animal.setHobby(hobby);
		animal.setIs_available(is_available);
		animal.setIs_broken(is_broken);
		animal.setPicture(picture);
	
		entitymanager.persist(animal);
		entitymanager.getTransaction().commit();
		closeFactoryAndManager();
	}
	
	public void deleteAnimal(int animalId) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Animal animal = entitymanager.find(Animal.class, animalId);
		entitymanager.remove(animal);

		entitymanager.getTransaction().commit();
		closeFactoryAndManager();
	}

	public void listAnimals() {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("Select e " + "FROM Animal e");
		List<Animal> animals = (List<Animal>) query.getResultList();

		for (Animal animal : animals) {
			System.out.println(animal.toString());
		}

		entitymanager.getTransaction().commit();	
		closeFactoryAndManager();
	}
	
	public void createFactoryAndManager() {
		emfactory = Persistence.createEntityManagerFactory("RestService");
		entitymanager = emfactory.createEntityManager();
	}

	public void closeFactoryAndManager() {
		entitymanager.close();
		emfactory.close();
	}
}
