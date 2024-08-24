package com.example.pbleventhub;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import java.util.List;

@WebServlet("/upcomingEvents")
public class UpcomingEventsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<Event> events = new ArrayList<>();


           try
           {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventhub", "root", "@AMIT2005");


                PreparedStatement ps = con.prepareStatement("SELECT * FROM eventcreation WHERE EventName >= CURDATE() ORDER BY EventName ASC");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Event event = new Event();

                    event.setEventName(rs.getString("eventName"));
                    event.setEventDate(rs.getString("eventDate"));
                    event.setEventTime(rs.getString("eventTime"));
                    event.setEventVenue(rs.getString("eventVenue"));
                    event.setEventDescription(rs.getString("eventDescription"));
                    event.setEventType(rs.getString("eventType"));
                    event.setTicketOptions(rs.getString("ticketOptions"));
                    events.add(event);


                }

            }
           catch (Exception e)
           {
                e.printStackTrace();
            }

           req.setAttribute("events", events);
           RequestDispatcher rd = req.getRequestDispatcher("/participantRegistration.html");
           rd.forward(req, resp);
        }



}
