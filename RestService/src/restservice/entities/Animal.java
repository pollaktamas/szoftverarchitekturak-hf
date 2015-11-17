package restservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Animal {
	
	@Id
	@XmlElement
	private int id;
	@XmlElement
	private String species;
	@XmlElement
	private String breed;
	@XmlElement
	private String sex;
	@XmlElement
	private Integer age;
	@XmlElement
	private String color;
	@XmlElement
	private Integer volume;
	@XmlElement
	private Integer weight;
	@XmlElement
	private String favourite_meal;
	@XmlElement
	private String hobby;
	@XmlElement
	private String is_available;
	@XmlElement
	private String is_broken;
	@XmlElement
	private String picture;
	@XmlElement
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
	
	public void removeOwner() {
		this.owner = null;
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", species=" + species + ", breed=" + breed + ", sex=" + sex + ", age=" + age + ", color=" + color + ", volume=" + volume +
				", weight=" + weight + ", favourite_meal=" + favourite_meal + ", hobby=" + hobby + ", is_available=" + is_available + 
				", is_broken=" + is_broken + ", picture=" + picture + ", owner=" + owner + "]";
	}
}
