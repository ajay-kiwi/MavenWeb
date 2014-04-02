<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="select-list" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="options" required="true" type="java.util.List" %>
<%@ attribute name="selected" type="java.lang.String" %>
<select id="${id }" name="${name }" class="form-control">
	<c:forEach items="${options }" var="option">
		<c:choose>
			<c:when test="${option.equals(selected) }">
				<option value="${option }" selected>${option }</option>
			</c:when>
			<c:otherwise>
				<option value="${option }">${option }</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>