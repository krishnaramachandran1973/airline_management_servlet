<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0" />
    <title>Flight List</title>
    <link
      href="css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css" />
  </head>
  <body>
    <div class="d-block px-3 py-2 text-center text-bold skippy purple-200">
      <a
        href="#"
        class="text-white text-decoration-none">
        Brownfield Airlines - Search Results
      </a>
    </div>
    <div class="container">
      <table class="table table-success table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Flight Number</th>
            <th scope="col">Departure from</th>
            <th scope="col">Destination</th>
            <th scope="col">Departure Time</th>
            <th scope="col">Arrival Time</th>
            <th scope="col">Seats</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach
            var="flight"
            items="${flights}"
            varStatus="theCount">
            <tr>
              <th scope="row">${theCount.count}</th>
              <td><c:out value="${flight.flightNumber}" /></td>
              <td><c:out value="${flight.departureAirport}" /></td>
              <td><c:out value="${flight.destinationAirport}" /></td>
              <td><c:out value="${flight.departureTime}" /></td>
              <td><c:out value="${flight.arrivalTime}" /></td>
              <td><c:out value="${flight.availableSeats}" /></td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
