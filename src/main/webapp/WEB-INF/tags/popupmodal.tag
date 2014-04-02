<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@tag language="java" description="modal" pageEncoding="UTF-8" %>
<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<div id="${id}" class="modal fade" data-backdrop="static">
	<div class="modal-password-dialog">
		<div class="modal-passwords-contents">
			<div class="modal-header">
				<a class="close" href="/" >&times;</a> 
			</div>
			<div class="modal-body">
		   		<div class="form-group">
				    <b>${title }</b>
		  	    </div>
				<jsp:doBody />
			</div>
   		</div>
   	</div>
</div>