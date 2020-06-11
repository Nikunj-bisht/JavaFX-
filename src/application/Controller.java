package application;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import datamodel.todoitem.todoitem;
import datamodel.todoitem.todosaved;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
public class Controller {
	
	@FXML
	private ListView<todoitem> todo;
	@FXML
	
	private TextArea ta1;
	private List<todoitem> items;
@FXML
private Label lb1;
@FXML
private BorderPane border;


	public void initialize() {
		  


//todosaved.getInstance().setitems(items);

todo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<todoitem>() {

	@Override
	public void changed(ObservableValue<? extends todoitem> arg0, todoitem arg1, todoitem arg2) {
		// TODO Auto-generated method stub
	if(arg2!=null) {
		todoitem item=todo.getSelectionModel().getSelectedItem();
	DateTimeFormatter time=DateTimeFormatter.ofPattern("MMM,d,yyyy");
		ta1.setText(item.getTask());
		
		lb1.setText(item.getDeadlines());

	}
	}
	
	
	
});
todo.getItems().setAll(todosaved.getInstance().getitems());
todo.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
todo.getSelectionModel().selectFirst();

		
	}
	
	
	@FXML
	public void adddialog() {
		System.out.println("running");
		Dialog<ButtonType> dialog=new Dialog<>();
		dialog.setTitle("Add new todoitem");
		dialog.setHeaderText("this will added to your list item");
		dialog.initOwner(border.getScene().getWindow());
		FXMLLoader fxmlloader=new FXMLLoader();
		fxmlloader.setLocation(getClass().getResource("tododialog.fxml")); 
		//dialog.initOwner(mainBorderPane.getScene().getWindow());
		try {

			
			System.out.println("running");

			dialog.getDialogPane().setContent(fxmlloader.load());
		}
			catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
		Optional<ButtonType> opt=dialog.showAndWait();
		
		if(opt.isPresent() && opt.get()==ButtonType.OK) {
			dialogController newitem=fxmlloader.getController();
			
			newitem.addfromdialog();
			todo.getItems().setAll(todosaved.getInstance().getitems());

		}
		else {
			
		}
		
		
		
		
		}
		
	}
	

	
	
	
	
	

