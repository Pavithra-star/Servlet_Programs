<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<h4 style=color:green><%= "Welcome to Ojas" %></h4>
<hr/>
<%! java.text.SimpleDateFormat st=new java.text.SimpleDateFormat("dd-MM-yyyy");
java.util.Date d= new java.util.Date();
%>

Date = <%= st.format(d) %>
<% for(int i = 1 ; i <=10; i++){
%>
<%=i %><br>
<%} %>