package Free_Palestine;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cont {

    @FXML
    private Button OpenScene;

    @FXML
    void OpenScene(ActionEvent event) throws IOException {
    	Stage primaryStage = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("palestine.fxml"));
        VBox pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
