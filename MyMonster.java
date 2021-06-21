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
import java.util.ArrayList;

class MyMonster extends Pane {
	String emote = "hello";
	String text = "Oh! Hello!";
	int score = 0;
	String question = "Have you gone outside today?";
	ArrayList<String> questions = new ArrayList<>();
	
	MyMonster(){
		questions.add("Have you eaten today?");
		questions.add("Have you seen any friends today?");
		questions.add("Have you exercised today?");
	}
	
	private void paint() {
		// Create a polygon and place polygon to pane
		Circle body = new Circle(200,100,80);
		Arc mouth = new Arc();
		Ellipse eye2 = new Ellipse();
		eye2.setRadiusX(10.0f);
		eye2.setRadiusY(10.0f);
		eye2.setCenterX(240.0f);
		eye2.setCenterY(80.0f);
		
		Ellipse eye1 = new Ellipse();
		eye1.setRadiusY(10.0f);
		eye1.setRadiusX(10.0f);
		eye1.setCenterX(160.0f);
		eye1.setCenterY(80.0f);
		
		body.setFill(Color.WHITE);
		body.setStroke(Color.BLACK);
		body.setStrokeWidth(5);
		
		eye1.setFill(Color.WHITE);
		eye1.setStroke(Color.BLACK);
		eye1.setStrokeWidth(5);
		
		eye2.setFill(Color.WHITE);
		eye2.setStroke(Color.BLACK);
		eye2.setStrokeWidth(5);

		switch(emote){
			case "sad":
				eye1.setCenterY(90.0f);
				eye2.setCenterY(90.0f);
				
				mouth.setCenterX(200.0f);
				mouth.setCenterY(130.0f);
				mouth.setRadiusX(25.0f);
				mouth.setRadiusY(25.0f);
				mouth.setStartAngle(0.0f);
				mouth.setLength(180.0f);
				break;
			case "shock":
				eye1.setRadiusY(15.0f);
				eye2.setRadiusY(15.0f);
				
				mouth.setCenterX(200.0f);
				mouth.setCenterY(135.0f);
				mouth.setRadiusX(25.0f);
				mouth.setRadiusY(25.0f);
				mouth.setStartAngle(0.0f);
				mouth.setLength(180.0f);
				break;
			case "wink":
				eye1.setRadiusY(3.0f);
							
				mouth.setCenterX(180.0f);
				mouth.setCenterY(110.0f);
				mouth.setRadiusX(25.0f);
				mouth.setRadiusY(25.0f);
				mouth.setStartAngle(150.0f);
				mouth.setLength(180.0f);
				break;
			default:
				mouth.setCenterX(200.0f);
				mouth.setCenterY(100.0f);
				mouth.setRadiusX(25.0f);
				mouth.setRadiusY(25.0f);
				mouth.setStartAngle(180.0f);
				mouth.setLength(180.0f);
		}
		
		setText(emote);
				
		getChildren().clear();
		getChildren().add(body); 
		getChildren().add(eye1); 
		getChildren().add(eye2); 
		getChildren().add(mouth); 
	}
	
	public String getEmote(){
		return this.emote;
	}
		
	public String getScore(){
		this.setScore(this.score+1);
		return String.valueOf(this.score);
	}
		
	public String getQuestion(){
		return this.question;
	}
	
	public String getText(){
		return this.text;
	}
		
	public void setScore(int newScore){
		this.score=newScore;
	}
	
	public void newQuestion(){
		if (questions.size()>0) {
			int index = (int)System.currentTimeMillis() % this.questions.size();
			
			
			String result = questions.get(index);
			questions.remove(index);
			
			this.question=result;
		}
		else{
			this.question="Please add some more questions.";	
		}
	}
	
	public void setNewQuestion(String newQuestion){
		this.questions.add(newQuestion);
	}
	
	public void setText(String emote){
		int random = 0; 
		
		switch (emote){
			case "sad":
				random = (int)(Math.random() * 2);
				if (random == 1){
					this.text="W-what? Please take better care of yourself!";
				}
				else{
					this.text="C-can you please take better care of yourself...?";
				}
				break;
			case "shock":
				random = (int)(Math.random() * 2);
				if (random == 1){
					this.text="What? Is there something you aren't telling me?";
				}
				else{
					this.text="Huh? What do you mean by that?";
				}
				break;
			case "wink":
				this.text="Better get to it soon then!";
				break;
			default:
				this.text="Yay! Nice job!";
		}
	}
	
	public void setEmote(String e){
		this.emote = e;
		paint();
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}