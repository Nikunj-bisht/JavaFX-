package datamodel.todoitem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;

public class todosaved {

	private static todosaved instance=new todosaved();
	
	private static String filename="filename.txt";
	
	private  List<todoitem> items;
	
	public static todosaved getInstance() {
		return instance;
	}
	public List<todoitem> getitems(){
		return this.items;
	}
	public void setitems(List<todoitem> item) {
		this.items=item;
	}
	public void additems(String task,String description,String date) {
		
		System.out.println("add");//send data to file

	items.add(new todoitem(task,description,date));
		
		
		
		
	}
	
	public void readfile() throws IOException {    //read from file 
		items=FXCollections.observableArrayList();
		
		Path path=Paths.get(filename);
		BufferedReader br=Files.newBufferedReader(path);
		String input;
System.out.println("ran");
		try {
			
			while((input=br.readLine())!=null) {
				
				String[] arrayoftodo=input.split("\t");
				String task=arrayoftodo[0];
				String detail=arrayoftodo[1];
				String deadline=arrayoftodo[2];
				
				todoitem item=new todoitem(task,detail,deadline);
				
				items.add(item);
	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public  void storedataintofile() throws IOException {    
		System.out.println("ran");//send data to file
		Path path=Paths.get(filename);
		BufferedWriter bw=Files.newBufferedWriter(path);

		try {
			Iterator<todoitem> item=items.iterator();
			
			
			while(item.hasNext()) {
				
				todoitem next=item.next();
				bw.write(String.format("%s\t%s\t%s",next.getTask(),next.getDetails(),next.getDeadlines()));
				bw.newLine();
				
				
				
			}
			
			
		} finally {
			// TODO Auto-generat
			if(bw!=null) {
				bw.close();
			}
		}
	}
	
}
