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

public class Delete extends Application{
	private BorderPane root;
	private GridPane gpane;
	private HBox hbox;
	private TextField tf1;
	private Label l1,l2;
	private Button btn;
	private VBox vbox;
	@Override
	public void start(Stage primaryStage)  {
		Stage stage=new Stage();
		root=new BorderPane();
		hbox=new HBox();
		tf1=new TextField();
		tf1.setPromptText("Enter Name to delete a Martyr");
		l1=new Label("Martyr Name");
		btn=new Button("Delete Martyr");
		l2=new Label("");
		l2.setStyle("-fx-text-color:red");
		vbox=new VBox();
		
		hbox.getChildren().addAll(l1,tf1,btn);
		hbox.setSpacing(15);
		hbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox,l2);
		vbox.setAlignment(Pos.CENTER);
		root.setAlignment(hbox,Pos.CENTER);
		root.setCenter(vbox);
		Scene scene=new Scene(root,500,250);
		stage.setScene(scene);
		stage.setTitle("Delete Martyr");
		stage.show();
	}
	public BorderPane getRoot() {
		return root;
	}
	public void setRoot(BorderPane root) {
		this.root = root;
	}
	public GridPane getGpane() {
		return gpane;
	}
	public void setGpane(GridPane gpane) {
		this.gpane = gpane;
	}
	public HBox getHbox() {
		return hbox;
	}
	public void setHbox(HBox hbox) {
		this.hbox = hbox;
	}
	public TextField getTf1() {
		return tf1;
	}
	public void setTf1(TextField tf1) {
		this.tf1 = tf1;
	}
	public Label getL1() {
		return l1;
	}
	public void setL1(Label l1) {
		this.l1 = l1;
	}
	public Button getBtn() {
		return btn;
	}
	public Label getL2() {
		return l2;
	}
	public VBox getVbox() {
		return vbox;
	}
	

	

}
