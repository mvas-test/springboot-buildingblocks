package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonView;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
//@JsonIgnoreProperties({"firstname", "lastname"}) -- Static Filtering JsonIgnore
// @JsonFilter(value="userfilter") -- Used for MAppingJacksonValue filtering section
public class User extends RepresentationModel<User> {

	@Id
	@GeneratedValue 
	@JsonView({Views.External.class, Views.Internal.class})
	private Long id;
	
	@NotEmpty(message="Username is a Mandatory field. Please provide a username.")
	@Column(name="USER_NAME", length=50, nullable=false, unique=true)
	@JsonView({Views.External.class, Views.Internal.class})
	private String username;
	
	@Size(min=2, message="FirstName should have at least 2 characters.")
	@Column(name="FIRST_NAME", length=50, nullable=false)
	@JsonView({Views.External.class, Views.Internal.class})
	private String firstname;
	
	@Column(name="LAST_NAME", length=50, nullable=false)
	@JsonView({Views.External.class, Views.Internal.class})
	private String lastname;
	
	@Column(name="EMAIL_ADDRESS", length=50, nullable=false)
	@JsonView({Views.External.class, Views.Internal.class})
	private String email;
	
	@Column(name="ROLE", length=50, nullable=false)
	@JsonView(Views.Internal.class)
	private String role;
	
	@Column(name="SSN", length=50, nullable=false, unique=true)
//	@JsonIgnore -- Static Filtering JsonIgnore
	@JsonView(Views.Internal.class)
	private String ssn;

	@OneToMany(mappedBy="user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	
	//No Argument Constructor
	public User() {
		super();
	}
	
	//Fields Constructor
	public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	//Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Order findOrder(Long orderid) {
		
		Order order = orders.stream()
				  .filter(o -> orderid.equals(o.getOrderid()))
				  .findAny()
				  .orElse(null);
		
		return order;
	}

	//To String
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
}
