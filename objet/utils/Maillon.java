package fr.fs.utils;

class Maillon<T> {
	private T instance;
	private Maillon<T> suivant;
	private Maillon<T> precedent;

	public Maillon(T instance) {
		this.instance = instance;
	}

	public void setSuivant(Maillon<T> suivant) {
		this.suivant = suivant;
	}

	public Maillon<T> getSuivant() {
		return suivant;
	}

	public Maillon<T> getPrecedent() {
		return precedent;
	}

	public void setPrecedent(Maillon<T> precedent) {
		this.precedent = precedent;
	}

	public void setInstance(T instance) {
		this.instance = instance;
	}

	public T getInstance() {
		return instance;
	}
}