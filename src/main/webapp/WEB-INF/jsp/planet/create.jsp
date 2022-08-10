<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Planet</h2>
	<c:url value="/rest/planet" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="planet">
	<div id="planetDTO_name">
		<label for="_name">Name:</label>
		<form:input cssStyle="width:300px" id="_name" path="name"/>
		<br/>
		<form:errors cssClass="errors" id="_name" path="name"/>
	</div>
	<div id="planetDTO_diameter">
		<label for="_diameter">Diameter:</label>
		<form:input cssStyle="width:300px" id="_diameter" path="diameter"/>
		<br/>
		<form:errors cssClass="errors" id="_diameter" path="diameter"/>
	</div>
	<div class="submit" id="planetDTO_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
