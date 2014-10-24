<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Guitar</title>
    </head>
    <body>
        <h3>Edit Guitar</h3>
        <form:form action="update.htm" modelAttribute="guitar" method="POST">
			<%-- This has to be here so that guitar id is not null and therefore the update does an edit, rather than
			create a brand new guitar. Either that, or, if you don't use this hidden form element, make sure you
			use the @SessionAttributes() annotation on the Controller class. --%>
			<%--<div style="display:none">
				<form:input path="id"/>
			</div>--%>
			<table>
				<tr>
					<td>Brand: </td>
					<td><form:input path="brand" /></td>
					<td><form:errors path="brand" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td>Model:</td>
					<td><form:input path="model" /></td>
					<td><form:errors path="model" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="year" /></td>
					<td><form:errors path="year" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" /></td>
					<td><form:errors path="price" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td>
						<form:select path="guitarType">
							<form:options  items="${guitarTypes}" itemLabel="name" itemValue="id" /> <!-- Note: itemValue must be given in order for editor to work properly! -->
					    </form:select>
					</td>
					<td><form:errors path="guitarType" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" /></td>
					<td colspan="2"><input type="button" value="Cancel" onclick="location='index.htm'" /></td>
				</tr>
			</table>
        </form:form>
    </body>
</html>
