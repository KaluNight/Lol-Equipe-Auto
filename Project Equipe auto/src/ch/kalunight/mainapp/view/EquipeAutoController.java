package ch.kalunight.mainapp.view;

import ch.kalunight.mainapp.EquipeAutoMainApp;
import ch.kalunight.mainapp.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EquipeAutoController {
	
	@FXML
	private TableView<Joueur> joueurTable;
	
	@FXML
	private TableColumn<Joueur, String> pseudoColumn;
	
	@FXML
	private TableColumn<Joueur, Integer> mmrColumn;
	
	@FXML
	private Label pseudoLabel;
	
	@FXML
	private Label mmrLabel;
	
	@FXML
	private Label rankLabel;
	
	//Reference au main app
	private EquipeAutoMainApp equipeAutoMainApp;
	
	/**
	 * Constructeur
	 */
	public EquipeAutoController() {
	}
	
	/**
	 * Initialise le controller. Cette m�thode est appel�e automatiquement apr�s que le fichier FXML a �t� charg�.
	 */
	@FXML
	private void initialize() {
		//Initialise les joueurs dans les colonnes.
		pseudoColumn.setCellValueFactory(cellData -> cellData.getValue().getPseudoProperty());
		mmrColumn.setCellValueFactory(cellData -> cellData.getValue().getMmrProperty().asObject());
	
		
	    showJoueurDetails(null);

	    // Ecoute les s�lections du tableau et montre les d�tails du joueur quand la s�lection est chang�.
	    joueurTable.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showJoueurDetails(newValue));
	}
	
	/**
	 * Affiche les d�tails du joueur � droite quand une cellule du tableau est s�lectionn�.
	 *
	 * @param Joueur ou null
	 */
	private void showJoueurDetails(Joueur joueur) {
	    if (joueur != null) {
	    	pseudoLabel.setText(joueur.getPseudo());
	    	mmrLabel.setText(joueur.getMmr().toString());
	    	rankLabel.setText(joueur.getRank());

	    } else {
	    	pseudoLabel.setText("");
	    	mmrLabel.setText("");
	    	rankLabel.setText("");
	    }
	}
	
	/**
	 * Appel� quand l'utilisateur appuie sur le bouton delete
	 */
	@FXML
	private void handleDeleteJoueur() {
		int selectedIndex = joueurTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex >= 0) {
			joueurTable.getItems().remove(selectedIndex);
		}
		else {
			//Si rien n'est s�lectionn�
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(equipeAutoMainApp.getPrimaryStage());
	        alert.setTitle("Aucune s�lection");
	        alert.setHeaderText("Aucun joueur s�lectionn�");
	        alert.setContentText("Merci de s�lectionn� un joueur.");
		}
	}
	/**
	 * Appel�e quand l'utilisateur � appuyer sur sur le bouton nouveau. Ouvre une boite de dialogue pour cr�er la nouvelle personne.
	 */
	@FXML
	private void handleNewJoueur() {
		Joueur tempJoueur = new Joueur();
	    boolean okClicked = equipeAutoMainApp.showJoueurEditDialog(tempJoueur);
	    if (okClicked) {
	    	equipeAutoMainApp.getJoueurData().add(tempJoueur);
	    }
	}

	/**
	 * Appel� quand l'utilisateur � appuyer sur le bouton Edit, ouvre un dialogue pour modifier les d�tails du Joueur.
	 */
	@FXML
	private void handleEditJoueur() {
	    Joueur selectedPerson = joueurTable.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        boolean okClicked = equipeAutoMainApp.showJoueurEditDialog(selectedPerson);
	        if (okClicked) {
	            showJoueurDetails(selectedPerson);
	        }

	    } else {
	        // Rien n'est s�lectionner
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(equipeAutoMainApp.getPrimaryStage());
	        alert.setTitle("Aucune s�lection");
	        alert.setHeaderText("Aucun joueur s�lectionn�");
	        alert.setContentText("Merci de s�lectionner un joueur dans le tableau.");

	        alert.showAndWait();
	    }
	}
    /**
     * Est appel� par l'application principale qui donne une reference de lui.
     * 
     * @param EquipeAutoMainApp
     */
    public void setMainApp(EquipeAutoMainApp equipeAutoMainApp) {
        this.equipeAutoMainApp = equipeAutoMainApp;

        // Ajoute la liste observable de donn�es dans le tableau.
        joueurTable.setItems(equipeAutoMainApp.getJoueurData());
    }
	
	
	
}
