package restservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import restservice.entities.Animal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Animals {
	
	@XmlElement
	public List<Animal> animals = new ArrayList<Animal>();
}
