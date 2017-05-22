package fr.epsi.myEpsi.jmx;

public class Premier implements PremierMBean {

	private static String nom = "PremierMBean";
	private int valeur = 100;
	
	@Override
	public String getNom() {
		return null;
	}

	@Override
	public int getValeur() {
		return 0;
	}

	@Override
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	@Override
	public void rafraichir() {
		System.out.println("Rafraichir les données");
	}
}
