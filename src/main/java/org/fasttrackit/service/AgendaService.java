package org.fasttrackit.service;

import org.fasttrackit.domain.Agenda;
import org.fasttrackit.persistance.AgendaRepository;
import org.fasttrackit.persistance.DatabaseConfiguration;
import org.fasttrackit.transfer.SaveAgendaRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaService {
    private AgendaRepository agendaRepository = new AgendaRepository();

   public void createTodoItem (SaveAgendaRequest request) throws SQLException, IOException, ClassNotFoundException {
       System.out.println( "Creating Contact" + request);
       agendaRepository.createTodoItem(request.getFirstName(), request.getLastName(), request.getPhoneNumber(), request.getEmail());
    }

    public List<Agenda> getTodoItem () throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving items in Agenda......" );
       return agendaRepository.getTodoItem();
    }

    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting items: " + id);
        agendaRepository.deleteToDoItem(id);
    }


    public void updateToDoItem(long id, SaveAgendaRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating contact" + request + "at id" + id);
        agendaRepository.updateToDoItem(request.getFirstName(), request.getLastName(), request.getPhoneNumber(), request.getEmail(), id);

    }

    public List<Agenda> findToDoItem(String request)  throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Finding " + request + " in agenda ....." );
       return agendaRepository.findTodoItem(request);
    }








}
