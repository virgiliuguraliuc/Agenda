package org.fasttrackit.web;

import org.fasttrackit.config.ObjectMapperConfiguration;
import org.fasttrackit.domain.Agenda;
import org.fasttrackit.service.AgendaService;
import org.fasttrackit.transfer.SaveAgendaRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/agenda/find")
public class AgendaServletSearch extends HttpServlet {


    private AgendaService agendaService = new AgendaService();


    //endpoint


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getQueryString();

        try {
            List<Agenda> findtodoItems = agendaService.findToDoItem(id);
            String queryJson = ObjectMapperConfiguration.getObjectMapper().writeValueAsString(findtodoItems);

            resp.getWriter().print(queryJson);
            resp.getWriter().flush();
            resp.getWriter().close();
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(200, "internal server error: " + e.getMessage());
        }

    }

    }

