<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag language="java" description="modal" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<div id="${id }" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<a href="/" class="close" data-dismiss="modal"><img class="img-cross" alt="" src="/resources/img/cross.png"></a> 
<!-- 				<button type="button" class="close" data-dismiss="modal">&times;</button> -->
				<h4 class="modal-title">${title }</h4>
			
			</div>
		
			<div class="modal-body">
				<jsp:doBody />
			</div>
   		</div>
   	</div>
</div>