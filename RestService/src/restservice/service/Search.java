package restservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Search {
	
	@XmlElement
	public String species;
	
	@XmlElement
	public String breed;
	
	@XmlElement
	public String is_available;
	
	@XmlElement
	public String is_broken;
}
