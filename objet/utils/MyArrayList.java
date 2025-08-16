package fr.fs.utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author François SACKEBANDT
 * @param <T> Classe générique
 */
public class MyArrayList<T> implements List<T>, Sortable<T> {

	private Random randomizer = new Random();
	Comparator<T> defaultComparator = this::compare;

	private int compare(T object1, T object2) {
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

	private Comparator<T> comparator;

	private static final int MIN_EXTEND_VALUE = 5;
	private T[] array;
	private int size = 0;

	/**
	 * Contruit une nouvelle ArrayList d'une capacité de 5.
	 */
	public MyArrayList() {
		array = (T[]) new Object[MIN_EXTEND_VALUE];
	}

	/**
	 * Construit une nouvelle arrayList de capacité déterminée.
	 * 
	 * @param initialCapacity Capacité initiale.
	 */
	public MyArrayList(int initialCapacity) {
		array = (T[]) new Object[initialCapacity];
	}

	public MyArrayList(T[] array) {
		size = array.length;
		int capacity = size + Math.max(MIN_EXTEND_VALUE, size / 10);
		this.array = (T[]) new Object[capacity];
		for (int index = 0; index < array.length; index++) {
			this.array[index] = array[index];
		}
	}

	/**
	 * Ajoute un élément dans la liste.
	 * 
	 * @param instance Elément à ajouter.
	 */
	public void add(T instance) {
		add(size, instance);
	}

	public void add(int index, T instance) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(index);
		if (size > array.length - 1)
			extendArray(size + 1);
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = instance;
		size++;

	}

	public void addAll(T[] array) {
		addAll(size, array);
	}

	public void addAll(int startIndex, T[] arrayToAdd) {
		if (startIndex > size || startIndex < 0)
			throw new IndexOutOfBoundsException(startIndex);
		int decalage = arrayToAdd.length;
		if (size + decalage > array.length - 1)
			extendArray(size + decalage);

		for (int index = size + decalage; index >= startIndex + decalage; index--) {
			array[index] = array[index - decalage];
		}
		for (int i = 0; i < decalage; i++) {
			array[startIndex + i] = arrayToAdd[i];
		}
		size += decalage;
	}

	public void clear() {
		size = 0;
	}

	public boolean contains(T instance) {
		return indexOf(instance) != -1;
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity <= array.length)
			return;
		T[] nouveauTableau = (T[]) new Object[minCapacity];
		for (int index = 0; index < size; index++) {
			nouveauTableau[index] = array[index];
		}
		array = nouveauTableau;
	}

	/**
	 * Récupère l'instance d'après sa position.
	 * 
	 * @param index Index de l'instance à récupérer.
	 * @return une instance.
	 */
	public T get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Indice hors limite");
		return array[index];
	}

	public int indexOf(T instance) {
		int indexOf = -1;
		int index = 0;
		while (indexOf == -1 && index < size) {
			if (array[index].equals(instance))
				indexOf = index;
			index++;
		}
		return indexOf;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int lastIndexOf(T instance) {
		int lastIndex = -1;
		int index = size - 1;
		while (lastIndex == -1 && index > 0) {
			if (array[index].equals(instance))
				lastIndex = index;
			index--;
		}
		return lastIndex;
	}

	public void remove(int indexToRemove) {
		if (indexToRemove >= size || indexToRemove < 0)
			throw new IndexOutOfBoundsException("Indice hors limite");
		for (int index = indexToRemove; index < size - 1; index++) {
			array[index] = array[index + 1];
		}
		size--;
	}

	public void remove(T instance) {
		int index = indexOf(instance);
		if (index != -1)
			remove(index);
	}

	public void remove(T[] instances) {
		for (T instance : instances) {
			remove(instance);
		}
	}

	public void set(int index, T instance) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Indice hors limite");
		array[index] = instance;
	}

	public void shuffle() {
		for (int index = 0; index < size / 2; index++) {
			int randomizeIndex = randomizer.nextInt(0, size);
			swap(index, randomizeIndex);
		}
	}

	public int size() {
		return size;
	}

	public void sort() {
		comparator = defaultComparator;
		for (int index = 1; index < size; index++) {
			insert(index);
		}
	}

	public void sort(Comparator<T> comparator) {
		this.comparator = comparator;
		for (int index = 1; index < size; index++) {
			insert(index);
		}
	}

	private void insert(int index) {
		T temp = array[index];
		int startIndex = index;
		while (startIndex > 0 && comparator.compare(array[startIndex - 1], temp) > 0) {
			array[startIndex] = array[startIndex - 1];
			startIndex--;
		}
		array[startIndex] = temp;
	}

	private void extendArray(int usedCapacity) {
		int newCapacity = usedCapacity + Math.max(MIN_EXTEND_VALUE, (usedCapacity / 10));
		ensureCapacity(newCapacity);
	}

	private void swap(int firstIndex, int secondIndex) {
		T temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int index = 0; index < size - 1; index++)
			stringBuilder.append(get(index) + ", ");
		if (size != 0)
			stringBuilder.append(get(size - 1));
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index != size;
			}

			@Override
			public T next() {
				if (index == size)
					throw new NoSuchElementException();
				return get(index++);
			}
		};
	}

}
