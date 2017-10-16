package ch.kalunight.mainapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Classe de l'objet Joueur
 * 
 * @author KaluNight
 *
 */


public class Joueur {

	private final StringProperty pseudo;
	private int mmr = 0;
	private final StringProperty rank;

	public Joueur(){
		this(null, 1000, null);
	}

	/**
	 * Constructeur de la classe Joueur
	 * 
	 * @param pseudo
	 * @param mmr
	 */
	public Joueur(String pseudo, int mmr, String rank) {
		this.pseudo = new SimpleStringProperty(pseudo);
		this.mmr = new Integer(mmr);
		this.rank = new SimpleStringProperty(rank);
	}

	public int getMmr() {
		return mmr;
	}

	public void setMmr(int mmr) {
		this.mmr = mmr;
	}

	public StringProperty getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo.setValue(pseudo);
	}

	public StringProperty getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.pseudo.setValue(rank);
	}





}
