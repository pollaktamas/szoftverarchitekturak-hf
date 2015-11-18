package restservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import restservice.entities.User;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Users {
	
	@XmlElement
	public List<User> users = new ArrayList<User>();
}
