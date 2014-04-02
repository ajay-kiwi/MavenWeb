<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="layout" pageEncoding="UTF-8" %>
<%@ attribute name="css" fragment="true" %>
<%@ attribute name="jsMain" required="true" type="java.lang.String" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
		<META HTTP-EQUIV="Expires" CONTENT="-1">
		<title>Intel QS Sense-Making Tool</title>
		<link rel="stylesheet" href="/resources/css/third-party/bootstrap-3.0.0.css" />
		<link rel="stylesheet" href="/resources/css/third-party/font-awesome.css" />
		<link rel="stylesheet" href="/resources/css/main.css" />
		<jsp:invoke fragment="css" />

<script type="text/javascript">
onload=function(){
//var e=document.getElementById("refreshed");
//if(e.value=="no")e.value="yes";
//else{e.value="no";location.reload();}
}</script>
  	</head>
  	<body class="prototype">
    	<jsp:doBody/>
		<script src="/resources/js/third-party/require-2.1.9.js"></script>
		<script>
			require(['/resources/js/common.js'], function loadMain() {
			  require(['bootstrap'], function loadModule() {
			  	require(['${jsMain }']);
			  });
			});
		</script>
  	</body>
</html>