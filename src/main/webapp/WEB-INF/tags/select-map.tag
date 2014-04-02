<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="select-map" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="options" required="true" type="java.util.Map" %>
<%@ attribute name="selected" type="java.lang.String" %>
<select id="${id }" name="${name }" class="form-control">
	<c:forEach items="${options }" var="option">
		<c:choose>
			<c:when test="${option.key.equals(selected) }">
				<option value="${option.value }" selected>${option.key }</option>
			</c:when>
			<c:otherwise>
				<option value="${option.value }">${option.key }</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>