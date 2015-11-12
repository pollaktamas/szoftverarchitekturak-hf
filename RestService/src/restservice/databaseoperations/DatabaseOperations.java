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
	
    /**
     * Client UC: register
     */
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

	/**
     * Client UC: login
     * 
     * Returns the user identified by the username password pair.
     * Return null, if the pair does not exist.
     */
	public User login(String username, String password) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		User user = null;	
		Query query = entitymanager.createQuery("Select e FROM User e WHERE e.username='" + username +"' AND e.password='" + password + "'");
		if (!query.getResultList().isEmpty()) {
			user = ((List<User>) query.getResultList()).get(0);
		}
		
		closeFactoryAndManager();	
		return user;
	}
	
	/**
	 * Client UC: browse
	 */
	public List<Animal> listAnimals() {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Query query = entitymanager.createQuery("Select e " + "FROM Animal e");
		List<Animal> animals = (List<Animal>) query.getResultList();
	
		closeFactoryAndManager();		
		return animals;
	}
	
	/**
	 * Client UC: search
	 * 
	 * Returns null if the search has no results.
	 */
	public List<Animal> searchAnimals(String species, String breed, String is_available, String is_broken) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		List<Animal> animals = null;	
		Query query = entitymanager.createQuery("Select e FROM Animal e WHERE e.species LIKE '%" + species +"%' AND e.breed LIKE '%" + breed +
				"%' AND e.is_available LIKE '%" + is_available + "%' AND e.is_broken LIKE '%" + is_broken + "%'");
		if (!query.getResultList().isEmpty()) {
			animals = (List<Animal>) query.getResultList();
		}
	
		closeFactoryAndManager();		
		return animals;
	}
	
	/**
	 * Client UC: rent animal
	 * 
	 * Returns false if the animal cannot be rented because is not available or is broken.
	 */
	public boolean rentAnimal(int userId, int animalId) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		boolean successfulRent = false;
		Animal animal = entitymanager.find(Animal.class, animalId);
		
		if (animal.getIs_available().equals("Y") && (animal.getIs_broken().equals("N"))) {
			animal.setOwner(userId);
			successfulRent = true;
		}

		entitymanager.getTransaction().commit();	
		closeFactoryAndManager();
		
		return successfulRent;
	}
	
	/**
	 * Client UC: bring back animal
	 */
	public void bringBackAnimal(int animalId) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Animal animal = entitymanager.find(Animal.class, animalId);
		animal.removeOwner();

		entitymanager.getTransaction().commit();	
		closeFactoryAndManager();
	}
	
	/**
	 * Administrator UC: insert animal
	 */
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
	
	/**
	 * Administrator UC: update animal
	 */
	public void updateAnimal(int animalId, String species, String breed, String sex, int age, String color, int volume, int weight, String favourite_meal,
			String hobby, String is_available, String is_broken, String picture) {
	
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Animal animal = entitymanager.find(Animal.class, animalId);
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
	
		entitymanager.getTransaction().commit();
		closeFactoryAndManager();
	}
	
	
	/**
	 * Administrator UC: remove animal
	 */
	public void deleteAnimal(int animalId) {
		createFactoryAndManager();
		entitymanager.getTransaction().begin();

		Animal animal = entitymanager.find(Animal.class, animalId);
		entitymanager.remove(animal);

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
