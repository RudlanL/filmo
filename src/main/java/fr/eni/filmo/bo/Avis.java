package fr.eni.filmo.bo;

public class Avis {
private int id ;
private String description;
private int rate ;
public Avis(int id, String description, int rate) {
	super();
	this.id = id;
	this.description = description;
	this.rate = rate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
} 
}