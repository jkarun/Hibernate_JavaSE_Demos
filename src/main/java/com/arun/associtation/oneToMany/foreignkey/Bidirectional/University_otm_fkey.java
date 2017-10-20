package com.arun.associtation.oneToMany.foreignkey.Bidirectional;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OneToMany_ForeignKey_bidirect_University")
public class University_otm_fkey {
	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String country;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="")
	private List<Student_otm_fkey> student;

	public University_otm_fkey() {
    }
 
    public University_otm_fkey(String name, String country) {
        this.name = name;
        this.country = country;
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Student_otm_fkey> getStudent() {
		return student;
	}

	public void setStudent(List<Student_otm_fkey> student) {
		this.student = student;
	}
	
	 @Override
	    public String toString() {
	        return "University [id=" + id + ", name=" + name + ", country="
	                + country + "]";
	    }
	
}
