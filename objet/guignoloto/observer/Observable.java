package fr.fs.guignolo.observer;

public abstract class Observable {
	private Observer[] observers = new Observer[5];

	public void addObserver(Observer observer) {
		if (isIn(observer))
			return;
		int indicePlaceLibre = indexOf(null);
		observers[indicePlaceLibre] = observer;
	}

	public void removeObserver(Observer observer) {
		int indiceOf = indexOf(observer);
		if (indiceOf == -1)
			return;
		for (int indice = indiceOf; indice < observers.length - 1; indice++) {
			observers[indice] = observers[indice + 1];
		}
		observers[observers.length -1 ] = null;
	}

	public void notifyObservers() {
		for (Observer observer : observers)
			if (observer != null)
				observer.actualiser(this);
	}

	private boolean isIn(Observer observer) {

		return indexOf(observer) != -1;
	}

	private int indexOf(Observer observer) {
		int position = -1;
		int indice = 0;
		while (position == -1 && indice < observers.length) {
			if (observers[indice] == observer)
				position = indice;
			indice++;
		}
		return position;
	}
}
