<%@page import="fr.epsi.myEpsi.beans.User"%>
<jsp:inclide page:"header.jsp">
<nav class="navbar navbar-default">
		<p class="nav-text">EPSI</p>
		<% User user = (User) request.getSession().getAttribute("user");
		if(user!=null){%>		
		<p class="navbar-text navbar-right">Connecté en tant que <a href="#" class="navbar-link"><% out.print(user.getId()); %></a></p>
		<% } %>
</nav>

</body>
</html>