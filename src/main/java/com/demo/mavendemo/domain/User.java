package com.demo.mavendemo.domain;

import java.util.List;

public class User {
	private Integer id;
	private String name;
	private Address address;
	private Integer age;
	private Boolean isActive;
	private Integer addressId;
	private List<Car> cars;

	public User() {
	}

	public User(String name, Integer d) {
		this.name = name;
		this.addressId = d;
	}

	public User(String name, Integer d, Integer age) {
		this.name = name;
		this.addressId = d;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
