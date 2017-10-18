package ch.kalunight.mainapp.view;

import ch.kalunight.mainapp.EquipeAutoMainApp;
import ch.kalunight.mainapp.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EquipeAutoController {
	
	@FXML
	private TableView<Joueur> joueurTable;
	
	@FXML
	private TableColumn<Joueur, String> pseudoColumn;
	
	@FXML
	private TableColumn<Joueur, Integer> mmrColumn;
	
	//Reference au main app
	private EquipeAutoMainApp equipeAutoMainApp;
	
	/**
	 * Constructeur
	 */
	public EquipeAutoController() {
	}
	
	/**
	 * Initialise le controller. Cette méthode est appelée automatiquement après que le fichier FXML a été chargé.
	 */
	@FXML
	private void initialize() {
		//Initialise les joueurs dans les colonnes.
		pseudoColumn.setCellValueFactory(cellData -> cellData.getValue().getPseudoProperty());
		mmrColumn.setCellValueFactory(cellData -> cellData.getValue().getMmrProperty().asObject());
	}
	
    /**
     * Est appelé par l'application principale qui donne une reference de lui.
     * 
     * @param mainApp
     */
    public void setMainApp(EquipeAutoMainApp equipeAutoMainApp) {
        this.equipeAutoMainApp = equipeAutoMainApp;

        // Add observable list data to the table
        joueurTable.setItems(equipeAutoMainApp.getJoueurData());
    }
	
	
	
}
