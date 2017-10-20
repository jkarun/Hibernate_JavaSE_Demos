package com.arun.associtation.oneToone.sharedprimarykey.Unidirectional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="OneToOne_SharedPrimayKey_User")
public class User_sharedPrimaryKey {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	protected String username;

	@OneToOne(
			fetch = FetchType.LAZY, // Defaults to EAGER
			optional = false // Required for lazy loading with proxies!
	)
	@PrimaryKeyJoinColumn
	private Adreess_sharedPrimaryKey address;

	protected User_sharedPrimaryKey() {
	}
	
	protected User_sharedPrimaryKey(String name) {
		this.username = name;
	}

	public User_sharedPrimaryKey(Long id, String username) {
		this.id = id;
		this.username = username;
	}

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

	public Adreess_sharedPrimaryKey getAddress() {
		return address;
	}

	public void setAddress(Adreess_sharedPrimaryKey address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User_sharedPrimaryKey [id=" + id + ", username=" + username
				+ ", address=" + address + "]";
	}

	
}
