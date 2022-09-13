# CDE-MFPE-Project-Audit-Management-System

## Authors :

<table>
  <tr>
      <td>
        <a href="#">Sachin Babasaheb Bankar</a>
        </td>
      <td>
        <a href="#">Rohit Kumar</a>
        </td>
      <td>
        <a href="#">Abhishek Sharma</a>
        </td>
      <td>
        <a href="#">Ishita Kumari</a>
        </td>
      <td>
        <a href="#">Ayan Chattopadhyay</a>
        </td>
    </tr>
</table>

## Module Name::

* ### Audit-Authorization-Microservice :
  This module is used for doing the **Authentication** and **Authorization** part of our project. 
  This microsevice provides the endpoints for authentication and validation. This MS creates JWTs(JSON Web Token)
  for a authenticated user who is in Database and then it validates the user based on the JWT token passed in the
  "Authentication"-Request-Header.("Bearer j.w.t...")

  * #### --Endpoints : 
    <table>
        <thead>
            <th>Method</th>
            <th>Endpoint Path</th>
            <th>Returns</th>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td>/health-check</td>
                <td>String</td>
            </tr>
            <tr>
                <td>POST</td>
                <td>/authenticate</td>
                <td>ResponseEntity of String(JWT token)</td>
            </tr>
            <tr>
                <td>POST</td>
                <td>/validate</td>
                <td>ResponseEntity of AuthenticationResponse</td>
            </tr>
        </tbody>
    </table>

  * #### --Dependencies on Other microsevices : **None**

  * #### --Application Properties Toggle :<br/>
      JAR name = ay-authorization<br/>
      server.port=8100<br/>
      server.servlet.context-path=/auth<br/>
      User Database : H2(In-Memory)<br/>
      Data about authenticated users provided in : data.sql
      JWT token duration = 5mins(given)...You can change the properties from the application.properties file

