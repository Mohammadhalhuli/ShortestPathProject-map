package Free_Palestine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class Main extends Application  {



    public void start(Stage primaryStage) throws Exception {

		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("InterFace.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Palestine Map");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



    public static void main(String [] args) {
        launch(args);

    }


}

