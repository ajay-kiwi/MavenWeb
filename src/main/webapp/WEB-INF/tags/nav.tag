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
		<a id="logo" href="/" >
			<img src="/resources/img/intel.png" tabindex="-1"/>
		</a>
	</div>

    <div id="header_collapse" class="collapse navbar-collapse">

    	<ul class="nav navbar-nav navbar-right">

    		<li>
				<a href="/">My Experiments</a>
			</li>
			<li>
				<a href="/experiments/new">Create</a>
			</li>
			<li>
				<a href="/explore">Explore</a>
			</li>
			<li>
				<a href="/connectors">Streams</a>
			</li>
			<li class="dropdown">
				<a href="#" data-toggle="dropdown">
					<span>${viewer.displayname }</span>
					&nbsp;
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="/users/${viewer.username }/profile">Profile</a></li>
					<li><a href="#" id="logout_link">Sign Out</a>
				</ul>
			</li>
    	</ul>
    </div>
	<form id="logout_form" class="form-inline" method="POST" action="/logout">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
</nav>