package com.demo.mavendemo.domain;

import java.util.List;

public class User {
	private Integer id;
	private String name;
	private Address address;
	private Integer addressId;
	private List<Car> cars;

	public User() {
	}

	public User(String name, Integer d) {
		this.name = name;
		this.addressId = d;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addressId=" + addressId + "]";
	}

}
