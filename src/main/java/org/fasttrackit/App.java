package org.fasttrackit;

import com.mysql.cj.util.StringUtils;
import org.fasttrackit.persistance.AgendaRepository;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        AgendaRepository agendaRepository = new AgendaRepository();
      //  agendaRepository.createTodoItem("virgiliu", "guraliuc", "0742845514", "virgiliuguraliuc@gmail.com" );
       // agendaRepository.findTodoItem("virgiliu");
     //   System.out.print(agendaRepository.findTodoItem("maria"));

    }
}
