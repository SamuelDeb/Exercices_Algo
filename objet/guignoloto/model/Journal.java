package fr.fs.guignolo.model;

public class Journal {
	private String nom;
	private String email;
	
	public Journal(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}
	
	

}
