package ch.kalunight.mainapp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	private final IntegerProperty mmr;
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
	public Joueur(String pseudo, Integer mmr, String rank) {
		this.pseudo = new SimpleStringProperty(pseudo);
		this.mmr = new SimpleIntegerProperty(mmr);
		this.rank = new SimpleStringProperty(rank);
	}

	public IntegerProperty getMmrProperty() {
		return mmr;
	}

	public void setMmrProperty(Integer mmr) {
		this.mmr.set(mmr);
	}

	public StringProperty getPseudoProperty() {
		return pseudo;
	}

	public void setPseudoProperty(String pseudo) {
		this.pseudo.setValue(pseudo);
	}

	public StringProperty getRankProperty() {
		return rank;
	}

	public void setRankProperty(String rank) {
		this.pseudo.setValue(rank);
	}





}
