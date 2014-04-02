<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="layout" pageEncoding="UTF-8" %>
<%@ attribute name="connector" required="true" type="com.intel.qs.db.entity.Connector" %>
<div class="connector centered">
	<a tabindex="-1" href="/connectors/${connector.name}">
    	<img id="${connector.name.toLowerCase()}" src="/resources/img/connector-icons/${connector.name.toLowerCase()}.png">
    </a>
    <div>${connector.prettyName}</div>
</div>