<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Perfis</h3>
	</div>
	<div class="panel-body">
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>Nome</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${perfilList}" var="perfil">
					<tr>
						<td>${perfil.nome }</td>
						<td><a class="btn btn-warning btn-xs"
							href="<c:url value="/perfis/${perfil.id}"/>">Editar</a></td>
						<td>
							<form action="<c:url value="/perfis/${perfil.id}" />"
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