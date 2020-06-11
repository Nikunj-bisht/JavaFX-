package application;
import datamodel.todoitem.todosaved;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class dialogController {
    
	@FXML
	private TextField tf1;
	@FXML
	private TextArea ta1;
	@FXML
	private DatePicker dp1;
	
	
	  public void addfromdialog() {
		  
		  String task=tf1.getText().trim();
		  String description=ta1.getText().trim();
		  String date=dp1.getValue().toString();
		  System.out.println(task+" "+description);
		  todosaved.getInstance().additems(task,description,date);
		  
		  
	  }
	
	
	
}
