<%@ page import="data.entity.Contact" %>
<%@ page import="services.ContactServiceImpl" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>java</title>
</head>
<body>
<h3>Таблица</h3>
<%=new java.util.Date()%>
<br>
<table border="3">
    <tr>
        <th>Contact Name</th>
        <th>Contact Address</th>
        <th>Contact Phone Numbers</th>
    </tr>
    <%
        for (Map.Entry<String, Contact> entry : new ContactServiceImpl().getMapAllContacts().entrySet()) {
            Contact contact = entry.getValue();
    %>
    <tr>
        <td><%= contact.getName() %>
        </td>
        <td><%= contact.getAddress() %>
        </td>
    </tr>
    <%
        for (int phoneNumber : contact.getListPhoneNumbers()) {
    %>
    <tr>
        <td><%= phoneNumber %>
        </td>
    </tr>
    <% }
    }
    %>
</table>
</body>
</html>