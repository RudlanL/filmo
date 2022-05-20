package fr.eni.filmo.bo;

public class Genre {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	public Genre() {
		
	}
	public Genre(String name, int id) {
		this.setName(name);
		this.setId(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
