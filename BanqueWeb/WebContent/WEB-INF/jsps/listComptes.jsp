<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="compteBancaire.CompteBancaire" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des comptes</title>
</head>
<body>
Liste des comptes : <br/>
<br/>
<br/>
<table width="90%" >
<%
Iterator it = ((Collection)request.getAttribute("listComptes")).iterator();
while(it.hasNext()) {
CompteBancaire compte = (CompteBancaire)it.next();
%>
<tr>
<td><%= compte.getId() %></td>
<td><%= compte.getSolde() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>
