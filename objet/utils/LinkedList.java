package fr.fs.utils;

import java.util.Comparator;

public class LinkedList<T> extends AbstractLinkedList<T> implements Sortable<T>  {
	private Comparator<T> comparator;

	/**
	 * Ajoute un objet à la fin de la liste. (Est équivalent à add(Object)
	 * 
	 * @param object objet à ajouter à la liste.
	 */
	public void add(T object) {
		addLast(object);
	}

	/**
	 * Ajoute un objet à la fin de la liste. (Est équivalent à add(Object)
	 * 
	 * @param object objet à ajouter à la liste.
	 */
	public void addLast(T object) {
		size++;
		Maillon<T> newMaillon = new Maillon<>(object);
		if (first == null)
			first = last = newMaillon;
		else {
			nouveauDernier(newMaillon);
		}
	}

	/**
	 * Ajoute un objet au début de la liste.
	 * 
	 * @param object objet à ajouter à la liste.
	 */
	public void addFirst(T object) {
		size++;
		Maillon<T> newMaillon = new Maillon<>(object);
		if (first == null)
			first = last = newMaillon;
		else {
			nouveauPremier(newMaillon);
		}
	}

	/**
	 * Ajoute un objet à la position spécifiée.
	 * 
	 * @param index    position à laquelle on ajoute.
	 * @param instance objet à ajouter à la liste.
	 */
	public void add(int index, T instance) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Indice hors limite");
		if (index == 0)
			addFirst(instance);
		else if (index == size)
			addLast(instance);
		else
			insert(index, instance);
	}

	private void insert(int index, T instance) {
		Maillon<T> newMaillon = new Maillon<>(instance);
		moveCursor(index);
		cursor.getPrecedent().setSuivant(newMaillon);
		newMaillon.setPrecedent(cursor.getPrecedent());
		newMaillon.setSuivant(cursor);
		cursor.setPrecedent(newMaillon);
		indexOfcursor++;
		size++;
	}

	public void addAll(int index, T[] array) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Indice hors limite");
		for (T instance : array)
			add(index++, instance);
	}

	public void set(int index, T instance) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice hors limite");
		moveCursor(index);
		cursor.setInstance(instance);
	}

	public void sort() {
		sort(super.defaultComparator);
	}

	public void sort(Comparator<T> comparator) {
		this.comparator = comparator;
		int firstIndex = 0;
		int lastIndex = size - 1;
		while (monterBulle(firstIndex, lastIndex--))
			;
	}

	private boolean monterBulle(int firstIndex, int lastIndex) {
		boolean isEchange;
		isEchange = false;
		for (int index = firstIndex; index < lastIndex; index++) {
			moveCursor(index);
			if (comparator.compare(cursor.getInstance(), cursor.getSuivant().getInstance()) > 0) {
				T temp = cursor.getInstance();
				cursor.setInstance(cursor.getSuivant().getInstance());
				cursor.getSuivant().setInstance(temp);
				isEchange = true;
			}
		}
		return isEchange;
	}
}
