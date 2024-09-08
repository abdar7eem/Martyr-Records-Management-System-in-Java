package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ADD extends Application{
	private BorderPane root;
	private GridPane gpane;
	private VBox vbox;
	private Button btn;
	private TextField tf1,tf2,tf3,tf4,tf5;
	private Label l1,l2,l3,l4,l5,l6;
	@Override
	public void start(Stage primaryStage)  {
		Stage stage=new Stage();
		vbox=new VBox();
		root=new BorderPane();
		btn=new Button("Add Martyr");
		gpane=new GridPane();
		tf1=new TextField();
		tf2=new TextField();
		tf3=new TextField();
		tf4=new TextField();
		tf5=new TextField();
		
		tf1.setPromptText("Ex.Samer");
		tf2.setPromptText("Ex.20");
		tf3.setPromptText("Ex.Nablus");
		tf4.setPromptText("MM/DD/YYYY");
		tf5.setPromptText("Ex.m");
		
		l1=new Label("Martyr Name");
		l2=new Label("Martyr Age");
		l3=new Label("Event Location");
		l4=new Label("Martyr Date");
		l5=new Label("Martyr Gender");
		l6=new Label("");
		l6.setStyle("-fx-text-fill:red");
		l6.setPadding(new Insets(15));
		
		gpane.add(l1, 0, 0);
		gpane.add(tf1, 1, 0);
		gpane.add(l2, 0, 1);
		gpane.add(tf2, 1, 1);
		gpane.add(l3, 0, 2);
		gpane.add(tf3, 1, 2);
		gpane.add(l4, 0, 3);
		gpane.add(tf4, 1, 3);
		gpane.add(l5, 0, 4);
		gpane.add(tf5, 1, 4);
		
		gpane.setHgap(10);
		gpane.setVgap(10);
		gpane.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(15));
		vbox.setSpacing(15);
		vbox.getChildren().addAll(gpane,btn,l6);
		root.setCenter(vbox);
		
		Scene scene=new Scene(root,500,300);
		stage.setScene(scene);
		stage.setTitle("Add Martyr");
		stage.show();
	}
	public BorderPane getRoot() {
		return root;
	}
	public GridPane getGpane() {
		return gpane;
	}
	public VBox getVbox() {
		return vbox;
	}
	public Button getBtn() {
		return btn;
	}
	public TextField getTf1() {
		return tf1;
	}
	public TextField getTf2() {
		return tf2;
	}
	public TextField getTf3() {
		return tf3;
	}
	public TextField getTf4() {
		return tf4;
	}
	public TextField getTf5() {
		return tf5;
	}
	public Label getL1() {
		return l1;
	}
	public Label getL2() {
		return l2;
	}
	public Label getL3() {
		return l3;
	}
	public Label getL4() {
		return l4;
	}
	public Label getL5() {
		return l5;
	}
	public Label getL6() {
		return l6;
	}
	

	

}
