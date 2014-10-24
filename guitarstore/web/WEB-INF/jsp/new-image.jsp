<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <h3>New Guitar Image</h3>
        <form:form action="save-image.htm" modelAttribute="guitar" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="file" id="image" name="image" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" /></td>
					<td colspan="2"><input type="button" value="Cancel" onclick="location='index.htm'" /></td>
				</tr>
			</table>
        </form:form>
    </body>
</html>
