package org.fasttrackit.persistance;

import org.fasttrackit.domain.Agenda;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    public void createTodoItem (String FirstName, String LastName, int PhoneNumber, String email) throws SQLException, IOException, ClassNotFoundException {
        String insertSql = "INSERT INTO to_do_list (description, deadline) VALUES (?, ?, ?, ?)";
        //try with resources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)
        ) {
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setInt(3, PhoneNumber);
            preparedStatement.setString(4, email);

            preparedStatement.executeUpdate();
        }
    }

    public List<Agenda> getTodoItem () throws SQLException, IOException, ClassNotFoundException {
        String query ="SELECT id, description, deadline, done FROM  to_do_list";

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()

        ) {

            ResultSet resultSet = statement.executeQuery(query);
            List<Agenda> toDoItems = new ArrayList<>();

            while (resultSet.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(resultSet.getLong("id"));
                agenda.setFirstName(resultSet.getString("first_name"));
                agenda.setLastName(resultSet.getString("last_name"));
                agenda.setPhoneNumber(resultSet.getInt("phone_number"));
                agenda.setEmail(resultSet.getString("email"));

                toDoItems.add(agenda);
            }

            return toDoItems;

        }
    }

    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql ="DELETE FROM to_do_list WHERE id = ?";


        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
    }


    public void updateToDoItem(long id, String FirstName, String LastName, int PhoneNumber, String email) throws SQLException, IOException, ClassNotFoundException {
        String upd ="UPDATE agenda SET first_name = ? last_name = ? phone_number = ? email = ? WHERE id = ?";


        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(upd)
        ){
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, FirstName);
            preparedStatement.setString(3, LastName);
            preparedStatement.setInt(4, PhoneNumber);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();

        }
    }



}
