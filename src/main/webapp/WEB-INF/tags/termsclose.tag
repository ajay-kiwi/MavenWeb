<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag language="java" description="modal" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<div id="${id }" class="modal fade" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content modal-content-round-close-button">
			<div class="modal-header">
			<a href="/" class="round-close-button"><img alt="" src="/resources/img/cross.png"></a> 
<!-- 				<button type="button" class="close" data-dismiss="modal">&times;</button> -->
					<h4 class="modal-title" style="display:inline-block;">${title }</h4>
			</div>
		
			<div class="modal-body">
				<jsp:doBody />
			</div>
   		</div>
   	</div>
</div>