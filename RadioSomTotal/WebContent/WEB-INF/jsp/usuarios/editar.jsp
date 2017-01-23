<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Editar Usuário</h3>
	</div>
	<div class="panel-body">
		<form action="<c:url value="/usuarios/${usuario.id }"/>" method="POST">
			<div class="form-group">
				<label for="nome">Nome do Usuário</label> <input id="nome"
					type="text" class="form-control" name="usuario.nome"
					value="${usuario.nome}" />
			</div>
			<div class="form-group">
				<label for="perfil">Perfil do Usuário</label> <select id="perfil"
					class="form-control" name="usuario.perfil.id">
					<option value="">Selecione um perfil</option>
					<c:forEach items="${perfilList}" var="perfil">
						<option value="${perfil.id}"
							<c:if test="${perfil.id == usuario.perfil.id }">selected</c:if>>
							${perfil.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="login">Login</label> <input id="login" type="text"
					class="form-control" name="usuario.login" value="${usuario.login}" />
			</div>
			<div class="form-group">
				<label for="senha">Senha</label> <input id="senha" type="password"
					class="form-control" name="usuario.senha" value="${usuario.senha}" />
			</div>
			<button type="submit" class="btn btn-default" name="_method"
				value="PUT">Enviar</button>
		</form>
	</div>
</div>

<!-- <h1>Editar Usuário</h1> -->
<%-- <form action="<c:url value="/usuarios/${usuario.id }"/>" method="POST"> --%>
<!-- 	<fieldset> -->
<!-- 		<legend>Editar Usuário</legend> -->
<!-- 		<label for="nome">Nome do Usuário</label>  -->
<%-- 		<input id="nome" type="text" name="usuario.nome" value="${usuario.nome}" /><br/> --%>
		
<!-- 		<label for="perfil">Perfil do Usuário</label> -->
<!-- 		<select id="perfil" name="usuario.perfil.id" > -->
<!-- 		    <option value="">Selecione um perfil</option> -->
<%-- 		    <c:forEach items="${perfilList}" var="perfil" > --%>
<%-- 		        <option value="${perfil.id}"  <c:if test="${perfil.id == usuario.perfil.id }">selected</c:if>> --%>
<%-- 		            ${perfil.nome} --%>
<!-- 		        </option> -->
<%-- 		     </c:forEach> --%>
<!-- 		</select><br/> -->
			
<!-- 		<label for="login">Login</label> -->
<%-- 		<input id="login" type="text"	name="usuario.login" value="${usuario.login}" /><br/> --%>
		
<!-- 		<label for="senha">Senha</label> -->
<%-- 		<input id="senha" type="password" name="usuario.senha" value="${usuario.senha}" /><br/> --%>
		
<!-- 		<button type="submit" name="_method" value="PUT">Enviar</button> -->
<!-- 	</fieldset> -->
<!-- </form> -->