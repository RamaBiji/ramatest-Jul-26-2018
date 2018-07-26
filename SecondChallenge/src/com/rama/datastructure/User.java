package com.rama.datastructure;

public class User {
	
	private String userId;
	private String name;
	private String phoneNumber;
	private Address address;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

	
	public void displayUser(){
		User usr=new User();
		Address address=new Address();
		address.setCity("newyork");
		address.setHouseNumber(12);
		address.setState("NY");
		address.setStreetAddress("Courtney Lading Place");
		address.setZipCode("81820");
		usr.setAddress(address);
		usr.setName("Gandhi");
		usr.setPhoneNumber("1234567890");
	    
		System.out.println("Name:" +usr.name);
		System.out.println("Phone:" +usr.phoneNumber);
		System.out.println("HouseNo:"+usr.getAddress().getHouseNumber());
		System.out.println("Street :"+usr.getAddress().getStreetAddress());
		System.out.println("City:"+usr.getAddress().getCity());
		System.out.println("State:"+usr.getAddress().getState());
		System.out.println("Zipcode:"+usr.getAddress().getZipCode());
		
		
	}

}
