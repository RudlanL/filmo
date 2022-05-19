package fr.eni.filmo.bo;

public class Genre {
	private String name;
	public Genre() {
		
	}
	public Genre(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
