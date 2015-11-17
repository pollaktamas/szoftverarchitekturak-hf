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
public class User {
	
	@Id
	@XmlElement
	private int id;
	@XmlElement
	private String username;
	@XmlElement
	private String password;
	@XmlElement
	private String is_admin;
	
	public User () {	
	}
	
	public User(int id, String username, String password, String is_admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}

	public int getId() {
		return id; 
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", is_admin=" + is_admin + "]";
	}
}
