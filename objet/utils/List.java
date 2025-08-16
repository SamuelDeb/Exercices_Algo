package fr.fs.utils;

import java.text.Collator;
import java.util.Locale;

public interface List<T> extends Iterable<T> {

	Collator collator = Collator.getInstance(Locale.FRENCH);
	
	public void add(T instance);

	public void addAll(T[] array);

	public void clear();

	public boolean contains(T instance);

	public T get(int index);

	public int indexOf(T instance);

	public boolean isEmpty();

	public int lastIndexOf(T instance);

	public void remove(int indexToRemove);

	public void remove(T instance);

	public void remove(T[] instances);

	public int size();
}
