package ch.kalunight.mainapp.view;

import ch.kalunight.mainapp.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JoueurEditDialogController {

	@FXML
	private TextField pseudoField;
	@FXML
	private TextField mmrField;
	@FXML
	private TextField rankField;


	private Stage dialogStage;
	private Joueur joueur;
	private boolean okClicked = false;

	/**
	 * Intitialise la classe controller. Méthode automatiquement appelé.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Définit le stage de cette boite de dialogue.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Définit la personne à être édité dans la boite de dialogue.
	 *
	 * @param joueur
	 */
	public void setPerson(Joueur joueur) {
		this.joueur = joueur;

		pseudoField.setText(joueur.getPseudo());
		mmrField.setText(joueur.getMmr().toString());
		rankField.setText(joueur.getRank());
	}

	/**
	 * Retourne true si l'utilisateur appuie sur OK, sinon false.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Appellé quand l'utilisateur appuie sur OK.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			joueur.setPseudoProperty(pseudoField.getText());
			joueur.setMmrPropertyStringToInt(mmrField.getText());
			joueur.setRankProperty(rankField.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Appelée quand l'utilisateur appuie sur Cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Controle que ce que l'utilisateur à écrit est valide.
	 *
	 * @return true si ce que l'utilisateur à rentrer est juste.
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (pseudoField.getText() == null || pseudoField.getText().length() == 0) {
			errorMessage += "Pseudo invalide !\n";
		}
		if (rankField.getText() == null || rankField.getText().length() == 0) {
			errorMessage += "Rank invalide !\n";
		}

		if (mmrField.getText() == null || mmrField.getText().length() == 0) {
			errorMessage += "MMR invalide !\n";
		} else {
			// try to parse the postal code into an int.
			try {
				Integer.parseInt(mmrField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "MMR Invalide (doit être un chiffre) !\n";
			}
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs invalide");
			alert.setHeaderText("Merci de corriger les champs invalide");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
