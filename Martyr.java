package application;

import java.util.Date;

public class Martyr {
	private String name;
	private int age;
	private String Location;
	private Date dof;
	private String gender;

	public Martyr(String name, int age, String location, Date dof, String gender) {
		super();
		this.name = name;
		this.age = age;
		Location = location;
		this.dof = dof;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public Date getDof() {
		return dof;
	}

	public void setDof(Date dof) {
		this.dof = dof;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
}
