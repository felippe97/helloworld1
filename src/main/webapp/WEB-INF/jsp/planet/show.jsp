<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="planet_name">
			<label for="_name">Name:</label>
			<div class="box" id="_name">${result.name}</div>
		</div>
		<br/>
		<div id="planet_diameter">
			<label for="_diameter">Diameter:</label>
			<div class="box" id="_diameter">${result.diameter}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Planet found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
