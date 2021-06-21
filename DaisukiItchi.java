//Jordan Ashe 

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.geometry.*;
import javax.swing.plaf.basic.*;

public class DaisukiItchi extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		
		Scene scene = new Scene(gui(),400,500);
		primaryStage.setTitle("ShowPolygon"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.setResizable(false);
		primaryStage.show(); // Display the stage
		
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	public Pane gui(){
		VBox maxPane = new VBox(10.0);
		GridPane gp = new GridPane();
		int userAnswer = 0;
		int random = 0;
		
		//dasukiitchi
		MyMonster dai = new MyMonster();
		
		//the title
		Label lebell = new Label("DaisukiItchi: By Jordan Ashe");
		lebell.setFont(Font.font("Times New Roman",FontWeight.BOLD, 20));
		lebell.setTextFill(Color.BLACK);
		
		//interactable buttons
		Button btn1 = new Button("Yes");
		Button btn2 = new Button("No");
		Button btn3 = new Button("Sorry...");
		Button btn4 = new Button("Not Yet!");
		
		btn1.setPrefWidth(100);
		btn2.setPrefWidth(100);
		btn3.setPrefWidth(100);
		btn4.setPrefWidth(100);
		
		//Daisuki prompt
		Label tfP = new Label("Test");
		tfP.setFont(Font.font("Times New Roman", 14));
		tfP.setTextFill(Color.BLACK);
	
		//question prompt
		Label tfQ = new Label("This is DaisukiItchi, do you like him?");
		tfQ.setFont(Font.font("Times New Roman", 20));
		tfQ.setTextFill(Color.BLACK);
		
		//score
		Label score = new Label("Score: 0");
		score.setFont(Font.font("Times New Roman", 12));
		score.setTextFill(Color.BLACK);
		
		//add your own questions!
		Label flavorTxt1 = new Label("Add your own questions!");
		Label flavorTxt2 = new Label("(Note: it works best when they are Yes/No questions)");
		flavorTxt1.setFont(Font.font("Times New Roman", 14));
		flavorTxt1.setTextFill(Color.BLACK);
		flavorTxt2.setFont(Font.font("Times New Roman", 14));
		flavorTxt2.setTextFill(Color.BLACK);
		TextField newQuestionTaker = new TextField();
		
		newQuestionTaker.setOnAction(e -> {
			dai.setNewQuestion(newQuestionTaker.getText());
			newQuestionTaker.setText("");
		});
		
		btn1.setOnAction(e -> {
			if (dai.questions.size()>0){
				dai.setEmote("joy");
				tfP.setText(dai.getText());
				score.setText("Score: " + dai.getScore());
			}
			tfQ.setText(dai.getQuestion());
			dai.newQuestion();
		});
		btn2.setOnAction(e -> {
			if (dai.questions.size()>0){
				dai.setEmote("sad");
				tfP.setText(dai.getText());
			}
			tfQ.setText(dai.getQuestion());
			dai.newQuestion();
		});
		btn3.setOnAction(e -> {
			if (dai.questions.size()>0){
				dai.setEmote("shock");
				tfP.setText(dai.getText());
			}
			tfQ.setText(dai.getQuestion());
			dai.newQuestion();
		});
		btn4.setOnAction(e -> {
			if (dai.questions.size()>0){
				dai.setEmote("wink");
				tfP.setText(dai.getText());
				score.setText("Score: " + dai.getScore());
			}
			tfQ.setText(dai.getQuestion());
			dai.newQuestion();
		});
		
		gp.add(btn1,0,0);
		gp.add(btn2,1,0);
		gp.add(btn3,1,1);
		gp.add(btn4,0,1);
		gp.setHalignment(btn1, HPos.CENTER);
		gp.setHalignment(btn2, HPos.CENTER);
		gp.setHalignment(btn3, HPos.CENTER);
		gp.setHalignment(btn4, HPos.CENTER);
		gp.setMaxWidth(200);
		
		maxPane.getChildren().add(lebell);
		maxPane.getChildren().add(tfQ);
		maxPane.getChildren().add(gp);
		maxPane.getChildren().add(tfP);
		maxPane.getChildren().add(dai);
		maxPane.getChildren().add(score);
		maxPane.getChildren().add(flavorTxt1);
		maxPane.getChildren().add(flavorTxt2);
		maxPane.getChildren().add(newQuestionTaker);
		maxPane.setAlignment(Pos.TOP_CENTER);
		return maxPane;
	} 
}