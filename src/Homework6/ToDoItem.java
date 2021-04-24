package Homework6;

public class ToDoItem {

    private String description;
    private Priority priority;
    private boolean status = false;
    private int id;

    public ToDoItem(int id, String description, Priority priority, boolean status) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public int getID() {
        return this.id;
    }

    public String getDescription() {
        System.out.println();
        return this.description;
    }

    public String getPriority() {
        return String.format("%s", this.priority);
    }

    public void markCompletion(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.priority, this.status);
    }
}

