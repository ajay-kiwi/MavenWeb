<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="layout" pageEncoding="UTF-8"%>
<%@ attribute name="user" required="true" type="com.intel.qs.db.entity.User"%>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="right" fragment="true" %>
<div id="user_header">
	<div id="user_details">
		<img id="ajaximg1" src="${userimg}" />
		<div id="user_details_text">
			<div id="user_details_name">${user.displayname }</div>
			<div id="user_details_title">
				<jsp:invoke fragment="title" />
			</div>
		</div>
	</div>
	<div id="user_header_right">
		<jsp:invoke fragment="right" />
	</div>
</div>