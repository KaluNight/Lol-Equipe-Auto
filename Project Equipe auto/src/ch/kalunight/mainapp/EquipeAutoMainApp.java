package ch.kalunight.mainapp;

import java.io.IOException;

import ch.kalunight.mainapp.view.EquipeAutoController;
import ch.kalunight.mainapp.view.JoueurEditDialogController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EquipeAutoMainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * Data observable
     */
    private ObservableList<Joueur> JoueurData = FXCollections.observableArrayList();
    
    //Valeur de test
    public EquipeAutoMainApp() {
    	JoueurData.add(new Joueur("KaluNight", 1250, "Streamer"));
    	JoueurData.add(new Joueur("Magouts", 1400, "Admin"));
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
	/**
	 * Ouvre la fenetre d'�ditage de joueur. Si l'utilisateur appuie
	 * sur OK, les changement sont sauvegard�es dans l'objet Joueur et true est retourn�es.
	 * 
	 * @param Joueur l'objet joueur �dit�
	 * @return true si l'utilisateur appuie sur OK, sinon false.
	 */
	public boolean showJoueurEditDialog(Joueur joueur) {
	    try {
	        // Charge le fichier FXML et cr�er un nouveau stage pour le PopUp.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(EquipeAutoMainApp.class.getResource("view/JoueurEditDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Cr�e un nouveau stage
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Editage Joueur");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // D�finit le joueur du controller
	        JoueurEditDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setJoueur(joueur);

	        // Affiche le dialogue et attends que l'utilisateur le referme.
	        dialogStage.showAndWait();

	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EquipeAutoMainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EquipeAutoMainApp.class.getResource("view/EquipeAutoOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            //Donne au controlleur l'acces � la main classe.
            EquipeAutoController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returne les joueurs de la liste observable
     */
    public ObservableList<Joueur> getJoueurData(){
    	return JoueurData;
    }
    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}