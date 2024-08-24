<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upcoming Events</title>
</head>
<body>
<h1>Upcoming Events</h1>
<form action="eventCreation" method="POST">
<table>
    <tr>
        <th>Event Name</th>
        <th>Date</th>
        <th>Time</th>
        <th>Venue</th>
        <th>Description</th>
        <th>Event Type</th>
        <th>Ticket Options</th>
        <th>Action</th>
    </tr>
    <c:forEach var="event" items="${events}">
        <tr>
            <td>${event.eventName}</td>
            <td>${event.eventDate}</td>
            <td>${event.eventTime}</td>
            <td>${event.eventVenue}</td>
            <td>${event.eventDescription}</td>
            <td>${event.eventType}</td>
            <td>${event.ticketOptions}</td>
            <td>
                <form action="registerEvent" method="post">
                    <input type="hidden" name="eventId" value="${event.eventName}">
                    <input type="submit" value="Register for Event">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
