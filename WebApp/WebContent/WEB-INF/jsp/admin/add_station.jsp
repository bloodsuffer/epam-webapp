<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" scope="page" ><fmt:message key = "add_station_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<body>
<div id = "wrap">
<%@ include file="/WEB-INF/jspf/header.jspf" %>



	<form id="addStation" action="controller" method = "post" class = "form-signin">
				
				<input type="hidden" name="command" value="addStation"/>
				<label><fmt:message key = "add_station_jsp.form.name" />:</label><input type="text" name="stationName" /><br>
				<input type="submit" value = "Add"/>
	</form>
	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
	
</body>
</html>