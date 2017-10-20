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
	 * @param rank
	 */
	public Joueur(String pseudo, Integer mmr, String rank) {
		this.pseudo = new SimpleStringProperty(pseudo);
		this.mmr = new SimpleIntegerProperty(mmr);
		this.rank = new SimpleStringProperty(rank);
	}

	public IntegerProperty getMmrProperty() {
		return mmr;
	}
	public Integer getMmr() {
		return mmr.get();
	}

	public void setMmrProperty(Integer mmr) {
		this.mmr.set(mmr);
	}

	public StringProperty getPseudoProperty() {
		return pseudo;
	}
	public String getPseudo() {
		return pseudo.get();
	}

	public void setPseudoProperty(String pseudo) {
		this.pseudo.setValue(pseudo);
	}

	public StringProperty getRankProperty() {
		return rank;
	}
	public String getRank() {
		return rank.get();
	}

	public void setRankProperty(String rank) {
		this.rank.setValue(rank);
	}
	public void setMmrPropertyStringToInt(String str) {
		this.mmr.set(Integer.parseInt(str));
	}




}
