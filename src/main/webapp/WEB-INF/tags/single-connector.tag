<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag language="java" description="single-connector" pageEncoding="UTF-8" %>
<%@ attribute name="css" fragment="true" %>
<%@ attribute name="modals" fragment="true" %>
<%@ attribute name="iconStreamCaption" fragment="true" %>
<%@ attribute name="connectorStatus" fragment="true" %>
<%@ attribute name="jsMain" type="java.lang.String" %>
<t:layout jsMain="${jsMain }">
<jsp:attribute name="css">
	<link rel="stylesheet" href="/resources/css/tags/single-connector.css" />
	<jsp:invoke fragment="css" />
</jsp:attribute>
<jsp:body>
<jsp:invoke fragment="modals" />
<div id="main">
	<t:nav />
	<div id="connector_header">
		<div id="connector_name">${connector.prettyName }</div>
		<a href="/connectors">&#x2190; Streams</a>
	</div>
	<div id="content" class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="centered">
					<div id="icon_stream">
						<img class="img-responsive" src="/resources/img/connector-icons/${connector.name.toLowerCase()}.png" />
					</div>
					<div id="icon_stream_caption">
						<jsp:invoke fragment="iconStreamCaption" />
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<p id="connector_description">
					<c:forEach items="${taggedDescription }" var="token">
						<c:choose>
							<c:when test="${token.first.equals(\"span\") }">
								<span>${token.second }</span>
							</c:when>
							<c:when test="${token.first.equals(\"link\") }">
								<a href="${connector.siteUrl} ">${token.second }</a>
							</c:when>
						</c:choose>
					</c:forEach>
				</p>
				<div id="connector_status">
					<jsp:invoke fragment="connectorStatus" />
				</div>
			</div>
		</div>
	</div>
</div>
</jsp:body>
</t:layout>