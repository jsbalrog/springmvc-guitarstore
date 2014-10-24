<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
        <style type="text/css">
            .label {
                font-weight: bold;
            }

            .output {
                padding-bottom: 5px;
            }
        </style>

</head>

<h3>Guitar Details</h3>

<c:if test="${empty guitar}">
    <div class="section">
	No guitar found
    </div>
</c:if>

<c:if test="${not empty guitar}">
    <div class="section">
	<fieldset>
            <div class="field">
		<div class="label">Brand:</div>
                <div class="output"><c:out value="${guitar.brand}" /></div>
            </div>
            <div class="field">
            	<div class="label">Model:</div>
				<div class="output"><c:out value="${guitar.model}" /></div>
            </div>
            <div class="field">
            	<div class="label">Year:</div>
                <div class="output"><c:out value="${guitar.year}" /></div>
            </div>
            <div class="field">
            	<div class="label">Price:</div>
				<div class="output"><c:out value="${guitar.price}" /></div>
            </div>
            <div class="field">
            	<div class="label">Type:</div>
				<div class="output"><c:out value="${guitar.guitarType.name}" /></div>
            </div>
			<div class="field">
            	<div class="label">Image:</div>
				<div class="output"><img src="${guitar.guitarImage}" /></div>
            </div>
	</fieldset>
    </div>
</c:if>

<div class="buttonGroup">
    <a href="<c:url value="/index.htm" />">
	New Search
    </a>
</div>
