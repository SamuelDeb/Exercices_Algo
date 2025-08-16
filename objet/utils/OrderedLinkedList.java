package fr.fs.utils;

import java.util.Comparator;

public class OrderedLinkedList<T> extends AbstractLinkedList<T> {

	public OrderedLinkedList() {
		super();
	}

	public OrderedLinkedList(Comparator<T> comparator) {
		super();
		this.defaultComparator = comparator;
	}

	@Override
	public void add(T object) {
		size++;
		Maillon<T> newMaillon = new Maillon<>(object);
		if (first == null)
			first = last = newMaillon;
		else {
			insert(newMaillon);
		}
	}

	private void insert(Maillon<T> newMaillon) {

		if (defaultComparator.compare(last.getInstance(), newMaillon.getInstance()) <= 0)
			nouveauDernier(newMaillon);
		else if (defaultComparator.compare(first.getInstance(), newMaillon.getInstance()) >= 0)
			nouveauPremier(newMaillon);
		else
			insererMaillon(newMaillon);
	}

	private void insererMaillon(Maillon<T> newMaillon) {
		Maillon<T> maillon = first;
		T valeur;
		do {
			maillon = maillon.getSuivant();
			valeur = maillon.getInstance();
		} while (defaultComparator.compare(valeur, newMaillon.getInstance()) < 0);
		insererAvant(maillon, newMaillon);
	}

	private void insererAvant(Maillon<T> maillon, Maillon<T> newMaillon) {
		newMaillon.setSuivant(maillon);
		newMaillon.setPrecedent(maillon.getPrecedent());
		maillon.setPrecedent(newMaillon);
		newMaillon.getPrecedent().setSuivant(newMaillon);
	}

}
