package Homework6;

import java.sql.*;
import java.util.ArrayList;

public class ToDoItems {

    private String title;
    private ArrayList<ToDoItem> toDoItems;
    private java.sql.Connection connection;

    public ToDoItems(String title, java.sql.Connection connection) {
        this.title = title;
        this.toDoItems = new ArrayList<ToDoItem>();
        this.connection = connection;
    }

    public int getSize() {
        return this.toDoItems.size() + 1;
    }

    public String getTitle() {
        return this.title;
    }

    public void addItem(ToDoItem item) {
        this.toDoItems.add(item);
    }

    public void deleteItem(int id) {
        String sql = "delete from todo_list where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertItem(ToDoItem item) {
        String sql = "insert into todo_list(id, description, priority, status) value(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setNull(1, java.sql.Types.NULL);
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setString(3, item.getPriority());
            preparedStatement.setBoolean(4, item.getStatus());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleItem(String sql) {
        try {
            Statement statement = connection.createStatement();
            this.toDoItems = new ArrayList<ToDoItem>();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String description = rs.getString("description");
                Priority priority = Priority.valueOf(rs.getString("priority").toUpperCase());
                Boolean status = rs.getBoolean("status");
                this.addItem(new ToDoItem(id, description, priority, status));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        for (ToDoItem item : this.toDoItems) {
            System.out.println(String.format("Darāmā lieta nr. %s:", item.getID()));
            System.out.println(String.format("Apraksts: %s ", item.getDescription()));
            System.out.println(String.format("Prioritāte: %s", item.getPriority()));
            System.out.println(String.format("Statuss: %s", item.getStatus()));
            System.out.println();
        }
    }

    public void displayItems() {
        String sql = "select id, description, priority, status FROM todo_list";
        this.handleItem(sql);
    }

    public void displayCompletedItems() {
        String sql = "select id, 'description', priority, 'status' FROM todo_list where 'status' = 1";
        this.handleItem(sql);
    }

    public void displayUncompletedItems() {
        String sql = "select id, 'description', priority, 'status' FROM todo_list where 'status' = 0";
        this.handleItem(sql);
    }

    public void markCompletion(int itemNumber, boolean completed) {
        try {
            if (itemNumber > 0) {
                String sql = "update todo_list set status = ? where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBoolean(1, completed);
                preparedStatement.setInt(2, itemNumber);
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Darāmo lietu saraksts: ", title);
    }
}
