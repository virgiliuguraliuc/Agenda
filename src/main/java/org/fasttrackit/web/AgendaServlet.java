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

    @WebServlet("/agenda")
    public class AgendaServlet extends HttpServlet {


        private AgendaService agendaService = new AgendaService();


        //endpoint
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            acccessControlHeaders(resp);
            SaveAgendaRequest request =
                    ObjectMapperConfiguration.getObjectMapper().readValue(req.getReader(), SaveAgendaRequest.class);

            try {
                agendaService.createTodoItem(request);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(201, "internal server error: " + e.getMessage());
            }

        }


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            acccessControlHeaders(resp);
            try {
                List<Agenda> todoItems = agendaService.getTodoItem();
                String responseJson = ObjectMapperConfiguration.getObjectMapper().writeValueAsString(todoItems);

                resp.getWriter().print(responseJson);
                resp.getWriter().flush();
                resp.getWriter().close();


            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(200, "internal server error: " + e.getMessage());
            }

        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            acccessControlHeaders(resp);
            String id = req.getParameter("id");

            try {
                agendaService.deleteToDoItem(Long.parseLong(id));
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(405, "internal server error: " + e.getMessage());
            }
        }

        @Override
        protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            acccessControlHeaders(resp);
            String id = req.getParameter("id");

            SaveAgendaRequest request =
                    ObjectMapperConfiguration.getObjectMapper().readValue(req.getReader(), SaveAgendaRequest.class);
            System.out.println(request+ "this is the servlet");
            try {
                agendaService.updateToDoItem(Long.parseLong(id), request);
            } catch (SQLException | ClassNotFoundException e) {
                resp.sendError(405, "internal server error: " + e.getMessage());
            }
        }
        //pre-flight requests
        @Override
        protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            acccessControlHeaders(resp);
        }

        private void acccessControlHeaders(HttpServletResponse resp) {
            resp.setHeader("Access-Control-Allow-Origin", "*" );
            resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            resp.setHeader("Access-Control-Allow-Headers", "content-type");
            resp.setHeader("XMLHttpRequest","*" );
        }

        //CORS cross origin resource sharing



    }