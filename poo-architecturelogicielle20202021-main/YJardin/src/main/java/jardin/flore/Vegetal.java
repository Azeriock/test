package jardin.flore;

public abstract class Vegetal {

	protected Etat etat;
	protected char dessin[];
	
	public Etat getEtat() {
		return etat;
	}
	
	public Vegetal() {	
		dessin = new char[6];
		dessin[0] = '_';
		dessin[1] = '.';
		dessin[2] = '|';
		dessin[5] = '#';	
		etat = Etat.GRAINE;
	}
	
	@Override
	public String toString() {
		return String.valueOf(dessin[etat.ordinal()]);
	}
	
	public void grandir() {
		this.etat = Etat.values()[this.etat.ordinal() + 1];
	}
	
}