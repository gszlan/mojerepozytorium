package pl.domena.myLearningProject1.model;

import java.sql.DatabaseMetaData;
import java.util.Date;

public class Cat {

	private String name;
	private Date birthDate;
	private Float weight;
	private String keeperName;
	
	public String introduceYourself() {
		return "Jestem " + this.name + " urodzony/a " + this.birthDate + ", moja waga to " + this.weight + ", a moim opiekunem jest " + this.keeperName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	
}
