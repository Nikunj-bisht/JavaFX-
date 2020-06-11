package datamodel.todoitem;

public class todoitem {

private String task;
private String details;
private String deadlines;

public todoitem(String task,String details,String deadlines) {
	this.setTask(task);
	this.setDetails(details);
	this.setDeadlines(deadlines);
}

public String getTask() {
	return task;
}

public void setTask(String task) {
	this.task = task;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

public String getDeadlines() {
	return deadlines;
}

public void setDeadlines(String deadlines) {
	this.deadlines = deadlines;
}
@Override
public String toString() {
	return this.task+" "+this.details+" "+this.deadlines;
}

}
