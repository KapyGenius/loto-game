package com.example;

// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.stage.Stage;

// import java.io.IOException;

// /**
//  * JavaFX App
//  */
// public class App extends Application {

//     private static Scene scene;

//     @Override
//     public void start(Stage stage) throws IOException {
//         scene = new Scene(loadFXML("primary"), 640, 480);
//         stage.setScene(scene);
//         stage.show();
//     }

//     static void setRoot(String fxml) throws IOException {
//         scene.setRoot(loadFXML(fxml));
//     }

//     private static Parent loadFXML(String fxml) throws IOException {
//         FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//         return fxmlLoader.load();
//     }

//     public static void main(String[] args) {
//         launch();
//     }

// }

// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.image.Image;
// import javafx.scene.paint.ImagePattern;
// import javafx.stage.Stage;

// public class App extends Application {
//     @Override
//     public void start(Stage stage) {
//         Label label = new Label("Hello, JavaFX!");
//         Scene scene = new Scene(label, 400, 200);
//         System.out.println("Hello, JavaFX!");
//         System.out.println(getClass().getResource("/pixou.png").toExternalForm());
//         ImagePattern img = new ImagePattern(new Image("pixou.png"));
//         stage.setScene(scene);
//         stage.setTitle("JavaFX with Maven");
//         stage.show();
//     }

//     public static void main(String[] args) {
//         launch();
//     }
// }

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
	//mon style a moi 
	style styl = new style();
	event e = new event();
	Label[] Value = {new Label(),new Label(),new Label(),new Label(),new Label(),new Label()};
	SequentialTransition sqt;
	public void start(Stage stage){

		//mon interface
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		ImagePattern img = new ImagePattern(new Image("loto.png"));
		root.setBackground(new Background(new BackgroundFill(img,null,null)));


		//au top de l'aplication
		BorderPane flow = new BorderPane();
		//menu application
		Menu fichier = new Menu("Option");
		Menu record = new Menu("Records");
		Menu help = new Menu("Help");
		Menu langue = new Menu("Langue");
		MenuBar listeMenu = new MenuBar();
		listeMenu.getMenus().addAll(fichier,record,help,langue);
		
		


		Text go = new Text("GO!"); go.setFill(styl.moneyColor);go.setEffect(styl.light);go.setFont(styl.fontBig);
		FlowPane fond = new FlowPane();
		ImageView pixouMoney = new ImageView(new Image("pixouMoney.png"));pixouMoney.setFitHeight(100);pixouMoney.setFitWidth(100);pixouMoney.setEffect(styl.reflection);
		styl.scale.setNode(pixouMoney);styl.scale.play();
		Text account = new Text(String.format("%, d$", 50000));account.setFill(styl.moneyColor);account.setEffect(styl.light2);
		account.setFont(styl.fontMoney);
		fond.getChildren().addAll(pixouMoney,account);
		flow.setTop(listeMenu);
		flow.setLeft(fond);
		flow.setRight(go);
		
		// au bottom de L'application
		GridPane gridButton = new GridPane();
		//mes constrain
		 ColumnConstraints column1 = new ColumnConstraints();
	     column1.setPercentWidth(20);
	     ColumnConstraints column2 = new ColumnConstraints();
	     column2.setPercentWidth(32);
	     ColumnConstraints column3 = new ColumnConstraints();
	     column3.setPercentWidth(33);
	     ColumnConstraints column4 = new ColumnConstraints();
	     column4.setPercentWidth(15);
	     gridButton.getColumnConstraints().addAll(column1, column2,column3, column4);
	     gridButton.setVgap(5);
	     int size = (int) Region.USE_COMPUTED_SIZE;
	     System.out.println(size);

	     //jajoute mes buttons
		Button[] btn = new Button[20];
		int[] raw = {0,1,2,3},col = {0,1,2,3,4};
		int p = 1;
		for(int x:raw){
			for(int y:col){
				btn[p-1]=new Button(Integer.toString(p));
				btn[p-1].setMinWidth(100);
				btn[p-1].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 20));
				btn[p-1].setEffect(styl.light3);
				gridButton.add(btn[p-1], y, x);
				btn[p-1].setOnMouseClicked(e.getbtn(btn[p-1]));
				p++;
			}
		}
		
		//au centre de l'application
		BorderPane center=new BorderPane();
		ImageView pixou = new ImageView(new Image("pixou.png"));pixou.setEffect(styl.reflection2);
		Label pixouAdvice = new Label("Salut Petit bienvenue dans mon monde tu es mon nouveau gerant bla bla bla");pixouAdvice.setWrapText(true);pixouAdvice.setGraphic(pixou);pixouAdvice.setMaxWidth(500);
		pixouAdvice.setFont(styl.fontAdvice);pixouAdvice.setTextAlignment(TextAlignment.CENTER);pixouAdvice.setTextFill(Color.CHOCOLATE);pixouAdvice.setEffect(styl.light4);
		pixouAdvice.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,new CornerRadii(50),new Insets(20,10,5,150))));
		center.setCenter(pixouAdvice);
		sqt = new SequentialTransition(pixouAdvice,styl.scale22,styl.scale21);
		
		//A gauche
		VBox BoxValue = new VBox(20);BoxValue.setPadding(new Insets(30,0,0,10));;
		
		for(Label x:Value){
			x.setText(null);x.setTextFill(Color.CORAL);x.setTextAlignment(TextAlignment.RIGHT);
			x.setFont(styl.fontAdvice);x.setEffect(styl.light2);
			x.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,new CornerRadii(50),new Insets(-10,-2,-10,-30))));
			BoxValue.getChildren().add(x);
		}
		
		
		root.setTop(flow);root.setBottom(gridButton);root.setCenter(center);root.setLeft(BoxValue);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("start");

	}
	
	public class event{
		EventHandler<MouseEvent> btn;
		public EventHandler<MouseEvent> getbtn(Button button){
			btn=new EventHandler<MouseEvent>(){
				public void handle(MouseEvent e){
					for(Label x:Value){
						if(x.getText()==null){
							x.setText(button.getText());
							x.setMinWidth(50);
							if(x!=Value[5])
								break;
						}
						if(Value[5].getText()!=null){
							sqt.play();
							
						}
					}
					
					RotateTransition rt= new RotateTransition(Duration.seconds(1),button);
					rt.setByAngle(360);rt.setCycleCount(2);rt.setAutoReverse(true);
					rt.play();
					button.setDisable(true);
					button.setEffect(styl.light);

					
				}
			};
			return btn;
			
		}
		public void rotate(Button b){
			RotateTransition rt= new RotateTransition(Duration.millis(5),b);
			rt.setByAngle(360);rt.setCycleCount(2);
			rt.play();
		}
	}
	
	
	public class style{
		Lighting light = new Lighting(new Light.Distant(105,125,Color.CORAL));
		Lighting light2 = new Lighting(new Light.Distant(195,125,Color.rgb(251, 241, 107)));
		Lighting light3 = new Lighting(new Light.Distant(195,105,Color.rgb(251, 241, 107)));
		Lighting light4 = new Lighting(new Light.Distant(195,105,Color.rgb(251, 241, 247)));
		Color moneyColor = Color.rgb(251, 231, 147);
		Font fontBig=Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 80);
		Font fontMoney=Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 40);
		Font fontAdvice=Font.font("Arial", FontWeight.NORMAL, FontPosture.ITALIC, 35);
		Reflection reflection = new Reflection();
		Reflection reflection2 = new Reflection();
		ScaleTransition scale = new ScaleTransition(Duration.seconds(2));
		ScaleTransition scale21 = new ScaleTransition(Duration.seconds(5));
		ScaleTransition scale22 = new ScaleTransition(Duration.seconds(5)); 
		public style(){
			light.setSurfaceScale(50);
			light2.setSurfaceScale(50);
			light3.setSurfaceScale(50);
			light4.setSurfaceScale(100);
			reflection.setFraction(0.8);
			reflection2.setFraction(0.2);
			scale.setCycleCount(2);scale.setAutoReverse(true);scale.setToX(1.5);scale.setToY(1.5);
			scale22.setCycleCount(1);scale22.setAutoReverse(true);scale22.setToX(0.0);scale22.setToY(0.0);
			scale21.setCycleCount(1);scale21.setAutoReverse(true);scale21.setToX(1);scale21.setToY(1);
		}
		 

		
	}

}