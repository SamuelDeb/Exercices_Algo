package fr.fs.utils;

import java.util.Comparator;

public interface Sortable<T> {
		
	public void sort();

	public void sort(Comparator<T> comparator);
}
