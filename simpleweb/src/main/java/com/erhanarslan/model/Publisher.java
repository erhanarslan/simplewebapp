package com.erhanarslan.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String addressLine;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany
	@JoinColumn(name="publisher_id" )
	private Set<Book> books = new HashSet<>();
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
	public Publisher(String city, String zip) {
		this.city = city;
		this.zip = zip;
	}
	
	
	
}
