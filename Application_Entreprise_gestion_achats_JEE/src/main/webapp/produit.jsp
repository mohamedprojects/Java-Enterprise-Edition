<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Controller.User" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import="Controller.Produit"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste de produits</title>
</head>
<body>
<%
User u = (User)request.getAttribute("User");
ArrayList<Produit> liste = (ArrayList<Produit>) request.getAttribute("ListeProduit");

if(u!=null)
{
%>
<b> Bienvenue à l'application de Gestion de
Produits<%out.println(u.getLogin());
//ArrayList<Produit> liste = (ArrayList<Produit>) request.getAttribute("ListeProduit");
%> </b>
<% };%>
</body>
<form action="/TP2JEE/AddProduct" method="get">
<label>ID Produit </label><input  type ="text" name="idProduit" required/>
<label>Nom Produit </label><input  type ="text" name="nomProduit" required/>
<label>Prix produit </label><input  type ="text" name="prixProduit" required/>
<label>Id Fournisseur </label><input  type ="text" name="idFournisseur" required/>
<input type= "submit" value="Ajouter produit"/>
</form>
<%
String msg = (String)request.getAttribute("msg");
if(msg!= null){
%>	
<%=msg %>
<%	
}
%>
<table border = "1">
<tr>
<td>Id Produit(</td>
<td>Nom Produit</td>
<td> Prix produit</td>
<td>Id Fournisseur</td>

</tr>

<% for (Produit p: liste){
%>
<tr>
<td> <%=p.getIdProduit() %></td>
<td> <%=p.getNomProduit() %></td>
<td> <%=p.getPrixProduit() %></td>
<td> <%=p.getIdFournisseur() %></td>
<td><a href="UpdateProduct?idproduit=<%=p.getIdProduit() %>"> Modifier </a></td>
<td><a href="DeleteProduct?idproduit=<%=p.getIdProduit() %>"> Supprimer </a></td>

</tr>
<%} %>
</table>

</html>