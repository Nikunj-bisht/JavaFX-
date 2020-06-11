package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import datamodel.todoitem.todosaved;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root=FXMLLoader.load(getClass().getResource("sample.fxml"));

			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("TodoList");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	@Override
	public void stop() {
		try {
			todosaved.getInstance().storedataintofile();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public void init() {
		try {
			todosaved.getInstance().readfile();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
