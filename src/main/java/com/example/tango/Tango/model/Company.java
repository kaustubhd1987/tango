package com.example.tango.Tango.model;

import java.util.List;

public class Company {

	private List<Business> businesses;

	public Company(List<Business> businesses) {
		this.businesses = businesses;
	}

	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
}
