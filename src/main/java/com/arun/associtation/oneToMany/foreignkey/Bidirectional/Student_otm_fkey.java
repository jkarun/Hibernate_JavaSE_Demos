package com.arun.associtation.oneToMany.foreignkey.Bidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OneToMany_ForeignKey_bidirect_Student")
public class Student_otm_fkey {

	@Id
	@GeneratedValue
	private long id;

	private String firstName;

	private String lastName;

	private String section;

	@ManyToOne(optional = false)
	@JoinColumn(name = "UNIVERSITY_ID")
	private University_otm_fkey university;

	public Student_otm_fkey(){
    }
 
    public Student_otm_fkey(String firstName, String lastName, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
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
 
    public String getSection() {
        return section;
    }
 
    public void setSection(String section) {
        this.section = section;
    }
 
    public University_otm_fkey getUniversity() {
        return university;
    }
 
    public void setUniversity(University_otm_fkey university) {
        this.university = university;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Student_otm_fkey))
            return false;
        Student_otm_fkey other = (Student_otm_fkey) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", section=" + section + "]";
    }
	
}
