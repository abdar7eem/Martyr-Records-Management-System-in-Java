package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Main extends Application {
	Stage stage;
	FileChooser fileChooser;
	File file;
	List arr=new List();
	ADD add=new ADD();
	Delete del=new Delete();
	Search search=new Search();
	VBox vbox;
	//***** important check image path before run *****
	@Override
	public void start(Stage primaryStage) {

		Count count=new Count();
		try {
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-color:#2aae1a;");
			Button Choose=new Button("Choose File");
			Choose.setPrefWidth(100);
			Choose.setStyle("-fx-background-color:#41d3f6;");

			vbox=new VBox();
			vbox.setAlignment(Pos.CENTER);
			vbox.setSpacing(15);
			try {
				//***** important check image path before run *****
				vbox.getChildren().addAll(new ImageView(new Image("\\img\\FileChooser.png",50,50,false,false)),Choose);
			}catch(Exception ex) {
				vbox.getChildren().addAll(new Label("Check image path"),Choose);
			}
			Choose.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent arg0) {
					fileChooser=new FileChooser();
					file=fileChooser.showOpenDialog(primaryStage);
					try {
						System.out.println(file.getName());
						root.setStyle("-fx-background-color:#A1662F;");
						Label fileName=new Label(file.getName());
						fileName.setPadding(new Insets(40));
						fileName.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,30));
						VBox vbox=new VBox();
						Button addbtn=new Button("Add Martyr");
						Button deletebtn=new Button("Delete Martyr");
						Button searchbtn=new Button("Search Martyr");
						Button countbtn=new Button("Count Martyr");
						addbtn.setPrefWidth(100);
						deletebtn.setPrefWidth(100);
						searchbtn.setPrefWidth(100);
						countbtn.setPrefWidth(100);
						vbox.getChildren().addAll(addbtn,deletebtn,searchbtn,countbtn);
						vbox.setAlignment(Pos.CENTER);
						vbox.setSpacing(15);
						vbox.setPadding(new Insets(15));
						root.setAlignment(fileName,Pos.CENTER);
						root.setTop(fileName);
						root.setCenter(vbox);
						addbtn.setOnAction(e->{
							try {
								add.start(primaryStage);
								add.getBtn().setOnAction(new EventHandler<ActionEvent>() {
									@Override
									public void handle(ActionEvent arg0) {
										try {
											if(add.getTf5().getText().equalsIgnoreCase("m") || add.getTf5().getText().equalsIgnoreCase("f") || add.getTf5().getText().equalsIgnoreCase("na")) {
												arr.add(new Martyr(add.getTf1().getText(),Integer.parseInt(add.getTf2().getText()),add.getTf3().getText(),new Date(add.getTf4().getText()),add.getTf5().getText()));
												add.getL6().setText("");
												add.getTf1().setText("");
												add.getTf2().setText("");
												add.getTf3().setText("");
												add.getTf4().setText("");
												add.getTf5().setText("");

												for(int i=0;i<arr.lenght();i++) {
													if(arr.get()[i] !=null) {
														System.out.println(arr.get()[i].getName());
													}
												}
											}
											else {
												add.getL6().setStyle("-fx-text-fill:red");
												add.getL6().setText("Martyr Gender must be M: male || F: female || NA");	
											}
										}catch(Exception ex) {
											add.getL6().setStyle("-fx-text-fill:red");
											add.getL6().setText("Person is not in list,Or try to enter valid data");
										}
									}
								});
							} catch (Exception e1) {
								add.getL6().setText("Check data you enterd");
							}
						});

						deletebtn.setOnAction(e->{
							del.start(primaryStage);
							del.getBtn().setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									try {
										if(del.getTf1().getText().isEmpty()) {
											del.getL2().setText("Enter a Correct Name");
											del.getL2().setStyle("-fx-text-fill:red;");
										}
										else {
											if(arr.checkToDelete(del.getTf1().getText())) {
												arr.delete(del.getTf1().getText());
												del.getTf1().setText("");
												del.getL2().setText("Person deleted");
											}
											else {
												del.getL2().setText("Martyr not found");
												del.getL2().setStyle("-fx-text-fill:red;");
											}

										}

									}catch(Exception ex) {
										del.getL2().setText("Enter a Correct Name");
									}
								}
							});
						});

						searchbtn.setOnAction(e->{
							search.start(primaryStage);
							search.getBtn().setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {
									String name=search.getTf1().getText();
									try {
										if(arr.search(search.getTf1().getText()) != null){
											search.getL2().setStyle("-fx-text-fill:blue");
											if(arr.search(name).getAge()==-1) {
												search.getL2().setText("Name: "+arr.search(name).getName() +"\nAge: "+"NA" +"\nEventLocation: "+arr.search(name).getLocation() +"\nDate of Death: "+arr.search(name).getDof().toString() +"\nGender: "+arr.search(name).getGender());
											}
											else {
												search.getL2().setText("Name: "+arr.search(name).getName() +"\nAge: "+arr.search(name).getAge() +"\nEventLocation: "+arr.search(name).getLocation() +"\nDate of Death: "+arr.search(name).getDof().toString() +"\nGender: "+arr.search(name).getGender());
											}
										}
										else {
											search.getL2().setStyle("-fx-text-fill:red");
											search.getL2().setText("Person is not in list");
										}
									}catch(Exception ex) {
										search.getL2().setStyle("-fx-text-fill:red");
										search.getL2().setText("Person is not in list");
									}
								}
							});
						});

						countbtn.setOnAction(e->{
							count.start(primaryStage);

							count.getBtn4().setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent arg0) {

									try {
										if(count.getGroup().getSelectedToggle().equals(count.getBtn1())) {
											if(count.getTf1().getText().equalsIgnoreCase("na")) {
												count.getTf2().setText(String.valueOf(arr.count(-1)));
												count.getLabel().setText(" ");
											}
											else {
												count.getTf2().setText(String.valueOf(arr.count(Integer.parseInt(count.getTf1().getText()))));
												count.getLabel().setText(" ");
											}
										}

										else if(count.getGroup().getSelectedToggle().equals(count.getBtn2())){
											count.getTf2().setText(String.valueOf(arr.count(new Date(count.getTf1().getText()))));
											count.getLabel().setText(" ");

										}
										else if(count.getGroup().getSelectedToggle().equals(count.getBtn3())) {
											if(!(count.getTf1().getText().equalsIgnoreCase("m")||count.getTf1().getText().equalsIgnoreCase("f")||count.getTf1().getText().equalsIgnoreCase("na"))) {
												count.getLabel().setText("Enter (M) for males || (F) for females || (NA) for UNKOWN");
											}
											else {
												count.getTf2().setText(String.valueOf(arr.count(count.getTf1().getText())));
												count.getLabel().setText(" ");
											}
										}

									}catch(Exception ex) {
										count.getLabel().setText("Try to enter a valid Data");
									}
								}
							});

						});


					}catch(Exception ex) {

					}

					try {
						System.out.println("****"+file.getName());
						read(file);
					} catch (FileNotFoundException e) {

					}catch (NullPointerException ex) {

					}
				}

			});



			root.setCenter(vbox);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Choose File");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void read(File file) throws FileNotFoundException {
		System.out.println(file.getName()+"*********");
		Scanner input=new Scanner(file);
		Date date;
		while(input.hasNextLine()) {
			String line=input.nextLine();
			String []tokens=line.split(",");

			for(int i=0;i<tokens.length;i++) {

				if(tokens[1].equalsIgnoreCase("NA")||tokens[1].equalsIgnoreCase("")) {
					tokens[1]=String.valueOf(-1);
				}
			}

			try {
				arr.add(new Martyr(tokens[0],Integer.parseInt(tokens[1]),tokens[2],new Date(tokens[3]),tokens[4]));
			}catch(NumberFormatException ex) {

			}
		}


		for(int i=0;i<arr.lenght();i++) {
			if(arr.get()[i] !=null) {
				System.out.println(arr.get()[i].getName());
			}
		}




	}

	public List getArr() {
		return arr;
	}


}
