	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="<c:url value= "/" />" >Radio Som Total</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	      	<li class="dropdown">
	    		<a href="#" class="dropdown-toggle" data-toggle="dropdown">TOP 10<span class="caret"></span></a>
	    		<ul class="dropdown-menu" role="menu">
	    			<li><a href="<c:url value= "/top10" />" >LISTAR</a></li>
	    			<li class="divider"></li>
	    			<li><a href="<c:url value= "/top10/novo" />" >ADICIONAR</a></li>
	    		</ul>
	      	</li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#">SOBRE</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ADMINISTRATIVO<span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="#" >LISTAR USUÁRIO</a></li>
	            <li><a href="#" >CADASTRAR USUÁRIO</a></li>
	          </ul>
	        </li>
	        <li class="dropdown">
	        	<c:choose>
	        		<c:when test="${false}">
	        			<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> USUÁRIO_X<span class="caret"></span></a>
			    		<ul class="dropdown-menu" role="menu">
			    			<li><a class="nav-link" href="#">MINHA CONTA</a></li>
			    			<li><a class="nav-link" href="#">LOGOUT</a></li>
			    		</ul>
	        		</c:when>
	        		<c:when test="${true }">
	        			<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> LOGIN<span class="caret"></span></a>
			    		<div class="dropdown-menu" style="padding: 17px;">
							<form class="form" id="formLogin"> 
								<input name="username" id="username" type="text" class="form-control" placeholder="Username"> 
								<input name="password" id="password" type="password" class="form-control" placeholder="Password"><br>
								<button type="button" id="btnLogin" class="btn btn-default">Login</button>
							</form>
						</div>
	        		</c:when>
	        	</c:choose>
	      	</li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>