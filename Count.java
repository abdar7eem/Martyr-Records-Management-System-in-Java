package application;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Count extends Application{
	private BorderPane root;
	private GridPane gpane;
	private TextField tf1,tf2;
	private ToggleGroup group;
	private RadioButton btn1,btn2,btn3;
	private Label label;
	private Button btn4;
	private VBox vbox;
	private HBox hbox1;
	private HBox hbox2;
	@Override
	public void start(Stage primaryStage)  {
		Stage stage=new Stage();
		root=new BorderPane();
		vbox=new VBox();
		hbox1=new HBox();
		hbox2=new HBox();
		tf1=new TextField();
		tf1.setPrefWidth(200);
		tf1.setPromptText("Enter what do you want to count...");
		tf2=new TextField();
		tf2.setEditable(false);
		tf2.setPrefWidth(50);
		
		group=new ToggleGroup();
		btn1=new RadioButton("Age");
		btn2=new RadioButton("Date Of Death");
		btn3=new RadioButton("Gender");
		btn4=new Button("Count");
		
		btn1.setToggleGroup(group);
		btn2.setToggleGroup(group);
		btn3.setToggleGroup(group);
		group.selectToggle(btn1);
		
		label=new Label("");
		label.setStyle("-fx-text-fill:red");
		
		hbox1.getChildren().addAll(btn1,btn2,btn3);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setSpacing(10);
		hbox2.getChildren().addAll(tf1,tf2,btn4);
		hbox2.setSpacing(10);
		hbox2.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(hbox1,hbox2,label);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(15);
		vbox.setAlignment(Pos.CENTER);
		
		
		
		

		
		root.setAlignment(vbox,Pos.CENTER);
		root.setCenter(vbox);
		Scene scene=new Scene(root,500,250);
		stage.setScene(scene);
		stage.setTitle("Count Martyr");
		stage.show();
	}
	
	public RadioButton getBtn1() {
		return btn1;
	}
	public RadioButton getBtn2() {
		return btn2;
	}
	public RadioButton getBtn3() {
		return btn3;
	}

	public TextField getTf1() {
		return tf1;
	}

	public TextField getTf2() {
		return tf2;
	}

	public ToggleGroup getGroup() {
		return group;
	}



	public BorderPane getRoot() {
		return root;
	}

	public GridPane getGpane() {
		return gpane;
	}

	public Button getBtn4() {
		return btn4;
	}

	public VBox getVbox() {
		return vbox;
	}

	public HBox getHbox1() {
		return hbox1;
	}

	public HBox getHbox2() {
		return hbox2;
	}

	public Label getLabel() {
		return label;
	}
	
	
	

}
