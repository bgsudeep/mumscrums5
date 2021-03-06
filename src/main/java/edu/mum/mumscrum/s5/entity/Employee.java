package edu.mum.mumscrum.s5.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author bgsudeep
 */
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;

	@Column(name="telephone")
	private String telephone;
	
	@Column(name="street")
	private String street;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;

	@Column(name="salary")
	private String salary;

	@OneToOne
	@JoinTable(name = "employee_user", joinColumns = { @JoinColumn(name = "employee_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private User user;
	
	@OneToOne(fetch=FetchType.EAGER, mappedBy="employee")
	private Release release;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="developer")
	@Cascade({ org.hibernate.annotations.CascadeType.MERGE,
		org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private Set<UserStory> userStoriesForDeveloper = new HashSet<UserStory>();
	public Set<UserStory> getUserStoriesForDeveloper() {
		return userStoriesForDeveloper;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="tester")
	@Cascade({ org.hibernate.annotations.CascadeType.MERGE,
		org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private Set<UserStory> userStoriesForTester = new HashSet<UserStory>();
	public Set<UserStory> getUserStoriesForTester() {
		return userStoriesForTester;
	}

	public void setUserStoriesForDeveloper(Set<UserStory> userStoriesForDeveloper) {
		this.userStoriesForDeveloper = userStoriesForDeveloper;
	}

	public void setUserStoriesForTester(Set<UserStory> userStoriesForTester) {
		this.userStoriesForTester = userStoriesForTester;
	}

	@Column(name="joinDate")
	private String joinDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", telephone=" + telephone + ", street=" + street + ", state=" + state + ", city=" + city + ", zip="
				+ zip + ", salary=" + salary + ", user=" + user + ", release=" + release + ", joinDate=" + joinDate
				+ "]";
	}
}
