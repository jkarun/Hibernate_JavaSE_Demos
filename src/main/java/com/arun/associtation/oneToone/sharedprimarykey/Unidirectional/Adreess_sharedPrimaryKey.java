package com.arun.associtation.oneToone.sharedprimarykey.Unidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OneToOne_SharedPrimayKey_address")
public class Adreess_sharedPrimaryKey {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;

    protected String street;
    protected String zipcode;
    protected String city;
    
    protected Adreess_sharedPrimaryKey() {
    }
    public Adreess_sharedPrimaryKey(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Adreess_sharedPrimaryKey [id=" + id + ", street=" + street
				+ ", zipcode=" + zipcode + ", city=" + city + "]";
	}
    
}
