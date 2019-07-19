package com.visa.training.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		String streetline1,streetline2,city,zip,state,country;
		
		
		public Address() {
			// TODO Auto-generated constructor stub
		}

		public Address(String streetline1, String streetline2, String city, String zip, String state, String country) {
			super();
			this.streetline1 = streetline1;
			this.streetline2 = streetline2;
			this.city = city;
			this.zip = zip;
			this.state = state;
			this.country = country;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStreetline1() {
			return streetline1;
		}

		public void setStreetline1(String streetline1) {
			this.streetline1 = streetline1;
		}

		public String getStreetline2() {
			return streetline2;
		}

		public void setStreetline2(String streetline2) {
			this.streetline2 = streetline2;
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

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
}
