package application;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Search extends Application{
	private BorderPane root;
	private GridPane gpane;
	private HBox hbox;
	private VBox vbox;
	private TextField tf1;
	private Label l1,l2;
	private Button btn;
	@Override
	public void start(Stage primaryStage)  {
		Stage stage=new Stage();
		root=new BorderPane();
		hbox=new HBox();
		tf1=new TextField();
		tf1.setPromptText("Enter Name to search for Martyr");
		l1=new Label("Martyr Name");
		l2=new Label("");
		btn=new Button("Search");
		vbox=new VBox();
		vbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(l1,tf1,btn);
		hbox.setSpacing(15);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox,l2);
		root.setAlignment(hbox,Pos.CENTER);
		root.setCenter(vbox);
		Scene scene=new Scene(root,500,250);
		stage.setScene(scene);
		stage.setTitle("Search Martyr");
		stage.show();
	}
	public BorderPane getRoot() {
		return root;
	}
	public GridPane getGpane() {
		return gpane;
	}
	public HBox getHbox() {
		return hbox;
	}
	public VBox getVbox() {
		return vbox;
	}
	public TextField getTf1() {
		return tf1;
	}
	public Label getL1() {
		return l1;
	}
	public Label getL2() {
		return l2;
	}
	public Button getBtn() {
		return btn;
	}
	
	
}