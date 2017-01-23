<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Usuários</h3>
	</div>
	<div class="panel-body">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Login</th>
					<th>Perfil</th>
					<th>Data de Criação</th>
					<th>Ultimo Acesso</th>
					<th>Perfil</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarioList}" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td>${usuario.login }</td>
						<td>${usuario.perfil.nome }</td>
						<td>${usuario.criadoEm }</td>
						<td>${usuario.ultimoAcesso }</td>
						<td><a class="btn btn-warning btn-xs"
							href="<c:url value="/usuarios/${usuario.id}"/>">Editar</a></td>
						<td>
							<form action="<c:url value="/usuarios/${usuario.id}" />"
								method="POST">
								<button class="btn btn-danger btn-xs" name="_method"
									value="DELETE">Excluir</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>