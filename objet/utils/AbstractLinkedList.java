package fr.fs.utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractLinkedList<T> implements List<T> {
	Maillon<T> first;
	Maillon<T> last;
	Maillon<T> cursor;
	int indexOfcursor;
	int size;
	Comparator<T> defaultComparator = this::compare;

	int compare(T object1, T object2) {
		if (object1 instanceof Number number1) {
			Number number2 = (Number) object2;
			if (number1.doubleValue() < number2.doubleValue())
				return -1;
			if (number1.doubleValue() > number2.doubleValue())
				return 1;
			return 0;
		}
		return collator.compare(object1.toString(), object2.toString());
	}

	protected AbstractLinkedList() {
		clear();
	}

	public void clear() {
		first = null;
		last = null;
		size = 0;
		clearCursor();
	}

	public void addAll(T[] array) {
		for (T instance : array)
			add(instance);
	}

	/**
	 * donne la taille de la liste.
	 * 
	 * @return taille de la liste.
	 */
	public int size() {
		return size;
	}

	/**
	 * Renvoit l'objet se trouvant à l'index spécifiée.
	 * 
	 * @param index position de l'objet recherché.
	 * @return l'objet se trouvant à cette position.
	 */
	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice hors limite");
		moveCursor(index);
		return cursor.getInstance();
	}

	protected void moveCursor(int index) {
		if (index == 0) {
			moveToFirst();
		} else if (index == size - 1) {
			moveToLast();
		} else {
			moveTo(index);
		}
	}

	private void moveTo(int index) {
		if (indexOfcursor == -1)
			moveToFirst();
		if (indexOfcursor < index) {
			afterCursor(index);
		} else
			beforeCursor(index);
	}

	private void beforeCursor(int index) {
		if (indexOfcursor - index > index) {
			moveToFirst();
			getAsc(index);
		} else
			getDesc(index);
	}

	private void afterCursor(int index) {
		if (index - indexOfcursor > size - index) {
			moveToLast();
			getDesc(index);
		} else
			getAsc(index);
	}

	private void moveToLast() {
		cursor = last;
		indexOfcursor = size - 1;
	}

	private void moveToFirst() {
		cursor = first;
		indexOfcursor = 0;
	}

	private void getAsc(int index) {
		while (indexOfcursor < index) {
			cursor = cursor.getSuivant();
			indexOfcursor++;
		}
	}

	private Maillon<T> getDesc(int index) {
		while (indexOfcursor > index) {
			cursor = cursor.getPrecedent();
			indexOfcursor--;
		}
		return cursor;
	}

	public int indexOf(T instance) {
		if (size == 0)
			return -1;
		int indexOf = -1;
		moveToFirst();
		while (cursor != null && indexOf == -1) {
			if (cursor.getInstance().equals(instance)) {
				indexOf = indexOfcursor;
			} else {
				cursor = cursor.getSuivant();
				indexOfcursor++;
			}
		}
		return indexOf;
	}

	public int lastIndexOf(T instance) {
		if (size == 0)
			return -1;
		int indexOf = -1;
		cursor = last;
		indexOfcursor = size - 1;
		while (cursor != null && indexOf == -1) {
			if (cursor.getInstance().equals(instance)) {
				indexOf = indexOfcursor;
			}
			cursor = cursor.getPrecedent();
			indexOfcursor--;
		}
		return indexOf;
	}

	public boolean contains(T instance) {
		return indexOf(instance) != -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void remove(T instance) {
		int indexToRemove = indexOf(instance);
		if (indexToRemove != -1)
			remove(indexToRemove);
	}

	/**
	 * Supprime l'objet se trouvant à l'index spécifiée.
	 * 
	 * @param index position de l'objet à supprimer.
	 */
	public void remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice hors limite");

		if (index == 0)
			removeFirst();
		else if (index == size - 1)
			removeLast();
		else {
			moveCursor(index);
			cursor.getPrecedent().setSuivant(cursor.getSuivant());
			cursor.getSuivant().setPrecedent(cursor.getPrecedent());
			size--;
		}
	}

	public void removeFirst() {
		first = first.getSuivant();
		size--;
		indexOfcursor--;
		if (size == 0)
			clearCursor();

	}

	public void removeLast() {
		last = last.getPrecedent();
		last.setSuivant(null);
		size--;
		if (size == 0) {
			clearCursor();
		}
	}

	private void clearCursor() {
		cursor = null;
		indexOfcursor = -1;
	}

	public void remove(T[] instances) {
		for (T instance : instances) {
			remove(instance);
		}
	}

	protected void nouveauDernier(Maillon<T> newMaillon) {
		newMaillon.setPrecedent(last);
		last.setSuivant(newMaillon);
		last = newMaillon;
	}

	protected void nouveauPremier(Maillon<T> newMaillon) {
		newMaillon.setSuivant(first);
		first.setPrecedent(newMaillon);
		first = newMaillon;
	}

	@Override
	public String toString() {
		if (size == 0)
			return "[]";
		StringBuilder stringBuilder = new StringBuilder("[");
		cursor = first;
		while (cursor != null) {
			stringBuilder.append(cursor.getInstance());
			cursor = cursor.getSuivant();
			if (cursor != null)
				stringBuilder.append(", ");
		}
		indexOfcursor = -1;
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Maillon<T> cursorIterator = first;

			@Override
			public boolean hasNext() {
				return cursorIterator != null;
			}

			@Override
			public T next() {
				if (cursorIterator == null)
					throw new NoSuchElementException();
				T instance = cursorIterator.getInstance();
				cursorIterator = cursorIterator.getSuivant();
				return instance;
			}
		};
	}
}
