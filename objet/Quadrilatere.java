package fr.fs.poo;

public class Quadrilatere {
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	private double distanceAB;
	private double distanceBC;
	private double distanceCD;
	private double distanceDA;
	private double distanceAC;
	private double distanceBD;
	private boolean isABParalleleCD;
	private boolean isBCparalleleDA;

	public Quadrilatere(Point a, Point b, Point c, Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;

		distanceAB = a.calculerDistance(b);
		distanceBC = b.calculerDistance(c);
		distanceCD = c.calculerDistance(d);
		distanceDA = a.calculerDistance(d);
		distanceAC = a.calculerDistance(c);
		distanceBD = b.calculerDistance(d);

		isABParalleleCD = a.calculerCoefficientDirecteur(b) == d.calculerCoefficientDirecteur(c);
		isBCparalleleDA = b.calculerCoefficientDirecteur(c) == d.calculerCoefficientDirecteur(a);
	}

	public boolean isQuadrilatere() {
		if (a.calculerCoefficientDirecteur(b) == b.calculerCoefficientDirecteur(c))
			return false;
		boolean resultat = !a.equals(b) && !a.equals(c) & !a.equals(d);
		resultat = resultat && !b.equals(c) && !b.equals(d);
		return resultat && !c.equals(d);
	}

	public boolean isTrapeze() {
		if (!isQuadrilatere())
			return false;
		return (isABParalleleCD || isBCparalleleDA);
	}

	public boolean isParallelogramme() {
		if (!isQuadrilatere())
			return false;
		return distanceAB == distanceCD && distanceBC == distanceDA;
	}

	public boolean isCerfVolant() {
		if (!isQuadrilatere())
			return false;
		if (distanceAB == distanceBC && distanceCD == distanceDA)
			return distanceBD > distanceBC && distanceBD > distanceCD;
		if (distanceDA == distanceAB && distanceBC == distanceCD)
			return distanceAC > distanceAB && distanceAC > distanceBC;
		return false;
	}

	public boolean isDeltoide() {
		if (!isQuadrilatere())
			return false;
		boolean condition1 = distanceDA == distanceAB && distanceBC == distanceCD;
		boolean condition2 = distanceBC == distanceAB && distanceCD == distanceDA;
		return (condition1 || condition2) && !isCerfVolant();
	}

	public boolean isLosange() {
		if (!isQuadrilatere())
			return false;
		return distanceAB == distanceBC && distanceBC == distanceCD && distanceCD == distanceDA;
	}

	public boolean isRectangle() {
		if (!isQuadrilatere())
			return false;
		return isParallelogramme() && new Trigone(a, b, c).isRectangle();
	}

	public boolean isCarre() {

		return isRectangle() && isLosange();
	}

	@Override
	public String toString() {
		return "Q{" + a + "," + b + "," + c + "," + d + "}";
	}

}
