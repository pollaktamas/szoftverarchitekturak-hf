package restservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Animal {
	
	@Id
	private int id;
	private String species;
	private String breed;
	private String sex;
	private Integer age;
	private String color;
	private Integer volume;
	private Integer weight;
	private String favourite_meal;
	private String hobby;
	private String is_available;
	private String is_broken;
	private String picture;
	private Integer owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getFavourite_meal() {
		return favourite_meal;
	}

	public void setFavourite_meal(String favourite_meal) {
		this.favourite_meal = favourite_meal;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getIs_available() {
		return is_available;
	}

	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}

	public String getIs_broken() {
		return is_broken;
	}

	public void setIs_broken(String is_broken) {
		this.is_broken = is_broken;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", species=" + species + ", breed=" + breed + ", sex=" + sex + ", age=" + age + ", color=" + color + ", volume=" + volume +
				", weight=" + weight + ", favourite_meal=" + favourite_meal + ", hobby=" + hobby + ", is_available=" + is_available + 
				", is_broken=" + is_broken + ", picture=" + picture + ", owner=" + owner + "]";
	}
}
