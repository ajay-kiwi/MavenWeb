<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="layout" pageEncoding="UTF-8" %>
<nav id="header" class="navbar navbar-default">
	<div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#header_collapse">
      		<span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
			<span class="icon-bar"></span>
    	</button>	    	
		<a id="logo" href="/">
			<img src="/resources/img/intel.png" />
		</a>
	</div>
    <div id="header_collapse" class="collapse navbar-collapse">
    	<ul class="nav navbar-nav navbar-right">
    		<li class="dropdown">
    			<a href="#" tabindex="-1" id="link_login_dropdown" class="dropdown-toggle" data-toggle="dropdown">Login</a>
    			<ul id="login_dropdown" class="dropdown-menu">
    				<li>
    					<form class="form" method="POST" action="j_spring_security_check">
				       		<div class="form-group">
				       			<input id="input_username_email" class="form-control" name="j_username" type="text" placeholder="username or email" required />
			       			</div>
			       			<div class="form-group">
				       			<input class="form-control" name="j_password" type="password" placeholder="Password" required />
				       		</div>
				       		<div class="form-group">
				       		  <label id="logbtn">
			   		            <input type="checkbox"  value="true"  name="_spring_security_remember_me" id="btn1" />&nbsp;Remember Me
			   		          </label>
			   		        </div>
				       		<a id="login_recovery" href="recovery">Forgot your password?</a>
				       		<input type="submit" id="login_submit" class="btn" value="login" />
				   		</form>
				   		<hr />
				   			<form action="<c:url value="/signin/facebook" />" method="POST">
						    	<input width="170" height="34" type="image" src="/resources/img/connectfacebook_btn.png" />
						    	<input type="hidden" name="scope" value="email,publish_stream,offline_access,read_stream" />		    
							</form>
				
		   		   			<form action="j_spring_openid_security_check" id="googleOpenId"	method="POST">
							   <input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id" />
							   <input width="170" height="34" type="image" src="/resources/img/connectgoogle_btn.png" />
							</form>   
					</li>
    			</ul>
    		</li>
    	</ul>
    </div>
</nav>
<script>
      window.onload=load();
      function load()
      {
	     if (!navigator.cookieEnabled)
         {
             document.getElementById("logbtn").style.display='none';
         }
      }
</script>