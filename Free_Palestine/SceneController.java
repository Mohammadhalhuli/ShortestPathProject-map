package Free_Palestine;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Callback;

public class SceneController implements Initializable {

	@FXML
	private VBox vbox;

	@FXML
	private AnchorPane anchorpane;

	@FXML
	private TextField sourceText;

	@FXML
	private TextField destinationText;


    @FXML
    private TextArea shortestPathText;

	@FXML
	private Label ShortstPt;

	@FXML
	private TextField totalCostText;

	@FXML
	private Button CButton;
	@FXML
	private Button Run;
	@FXML
    private Button Choose_File;
    static int num =0;
	static City sourceCity = null;
	static City destinationCity = null;
	 ArrayList<City> cities;
    static Dijkstra G=new Dijkstra();

	@Override
	public void initialize(URL location, ResourceBundle resources) {




		try {
			this.cities =G.readVertices();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cities.sort(Comparator.comparing(City::getFullName));
		for (City city : cities) {
			Button button = new Button();
			button.setLayoutX(city.getX());
			button.setLayoutY(city.getY());
			button.setUserData(city);
			unstyle((button));

			Label label = new Label(city.getName());
			label.setLayoutX(city.x + 5);
			label.setLayoutY(city.y);
			label.setVisible(true);

			anchorpane.getChildren().add(label);
			anchorpane.getChildren().add(button);
			city.setButton(button);

			button.setOnAction(event -> {
				if (sourceCity == null) {
					styleAsMainButton(button);
					sourceCity = (City) button.getUserData();
					sourceCity.getFullName();
					sourceText.setText(sourceCity.getFullName()+"");
				} else if (destinationCity == null) {
					styleAsMainButton(button);
					destinationCity = (City) button.getUserData();
					destinationCity.getFullName();
					destinationText.setText(destinationCity.getFullName()+"");

				} else {
					Clear_Button(null);
					styleAsMainButton(button);
					sourceCity = (City) button.getUserData();
					sourceCity.getFullName();
					sourceText.setText(sourceCity.getFullName()+"");
					destinationCity = (City) button.getUserData();
					destinationCity.getFullName();
					destinationText.setText(destinationCity.getFullName()+"");


					// sourceLabel.setText(sourceCity.getNotes());
				}
			});

		}
		try {
			G.readEdges();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



}

	  @FXML
	    void Choose_File_Button(ActionEvent event) {

num++;


	    }


	@FXML
	void Clear_Button(ActionEvent event) {
		ArrayList<Node> nodesToRemove = new ArrayList<>();
    	anchorpane.getChildren().forEach(node -> {
			if (node instanceof Line)
				nodesToRemove.add(node);

		});
		for (Node node : nodesToRemove) {
			anchorpane.getChildren().remove(node);
		}

		sourceCity = null;
		destinationCity = null;
		sourceText.setText("");
		destinationText.setText("");
		totalCostText.setText("");
		shortestPathText.setText("");
	}

	@FXML
	void anchroPaneAonAction(MouseEvent event) {



	}


	private void drawPathOnMap(City[] cities) {
        for (int i = 0; i < cities.length - 1; i++) {
            Line line = new Line(cities[i].getX() + 5, cities[i].getY() + 5, cities[i + 1].getX() + 5, cities[i + 1].getY() + 5);
            anchorpane.getChildren().add(line);
        }

    }
	public void styleAsMainButton(Button button) {
		double oldSize = button.getWidth();
		button.setStyle("-fx-background-color: Red;" + "-fx-min-width: 8px;" + "-fx-min-height: 8px;"
				+ "-fx-max-width: 8px;" + "-fx-max-height: 8px;");
		double newSize = button.getWidth();
		button.setLayoutX(button.getLayoutX() - (oldSize - newSize) / 2);
		button.setLayoutY(button.getLayoutY() - (oldSize - newSize) / 2);
	}
	public void unstyle(Button button) {
		button.setStyle("");
		button.setStyle("    -fx-min-width: 7px;\n" + "    -fx-min-height: 7px;\n" + "    -fx-max-width: 7px;\n"
				+ "    -fx-max-height: 7px;\n" + "    -fx-background-color: rgba(0, 0, 0, 0.7);");
		if (button.getUserData() != null) {
			button.setLayoutX(((City) button.getUserData()).getX());
			button.setLayoutY(((City) button.getUserData()).getY());

		}
	}






	@FXML
	void Run_Button(ActionEvent event) {

		 if (sourceCity != null && destinationCity != null) {
             Dijkstra graph = new Dijkstra(cities, sourceCity, destinationCity);
             graph.generateDijkstra();
             drawPathOnMap(graph.pathTo(destinationCity));

             shortestPathText.setText( graph.getPathString()+"");
             totalCostText.setText(graph.getDistanceString());
         }


	}


}

