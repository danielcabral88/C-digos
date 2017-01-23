<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Top 10</h3>
    </div>
    <div class="panel-body">
        <form id="buscarTop10Form" action="<c:url value="/top10/musicas"/>" method="POST" >
            <div class="btn-group" data-toggle="buttons">
                <label class="btn btn-default active">
                    <input type="radio" checked="checked" id="dia" name="opt" value="dia">Dia
                </label>
                <label class="btn btn-default">
                    <input type="radio" id="mes" name="opt" value="mes">Mês
                </label>
            </div>
            <div class="form-group">
                <label for="data">Data</label> <input
                    id="data" type="text" class="form-control"
                    name="top10.dia" value="" />
            </div>
            <div class="form-group">
                <label for="estacao ">Estação</label> 
                <select id="estacao" name="estacao.id" class="form-control">
                    <option value="">Selecione uma Estação</option>
                    <c:forEach items="${estacaoList}" var="estacao">
                        <option value="${estacao.id}">${estacao.nome}</option>
                    </c:forEach>
                </select> <br /> 
            </div>
            <div class="form-group">
                <label for="regiao">Região</label> 
                <select id="regiao" name="regiao.id" class="form-control">
                    <option value="">Selecione uma Região</option>
                    <c:forEach items="${regiaoList}" var="regiao">
                        <option value="${regiao.id}">${regiao.nome}</option>
                    </c:forEach>
                </select> <br /> 
            </div>
            <div class="form-group">
                <label for="estilo">Estilo Musical</label> 
                <select id="estilo" name="estilo.id" class="form-control">
                    <option value="">Selecione um Estilo</option>
                    <c:forEach items="${estiloList}" var="estilo">
                        <option value="${estilo.id}">${estilo.nome}</option>
                    </c:forEach>
                </select> <br /> 
            </div>
            <button id="btnbusca" class="btn btn-default ">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar
            </button><br /> 
	        <div class="panel panel-default">
	            <div class="panel-heading">
	                <h4 class="panel-title">Top 10</h4>
	            </div>
	            <div class="panel-body">
	                <table class="table table-stripped"  id="tabelatop10">
	                	<thead>
	                        <tr>
	                            <th>Musica</th>
	                            <th>Artista</th>
	                            <th>Estilo</th>
	                        </tr>
                        </thead>
	                    
	                    <%-- <thead>
	                        <tr>
	                            <th>Musica</th>
	                            <th>Artista</th>
	                            <th>Estilo</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <c:forEach items="${musicaList}" var="musica">
	                            <tr>
	                                <td>${musica.nome }</td>
	                                <td>${musica.artista}</td>
	                                <td>${musica.estilo.nome}</td>
	                            </tr>
	                        </c:forEach>
	                    </tbody> --%>
	                </table>
	            </div>
	        </div>
        </form>
    </div>
    
    <script>
        $(function(){
            var datepickerOptions = {
                dateFormat : 'dd-mm-yy',
                dayNames : [ 'Domingo', 'Segunda', 'Terça',
                        'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
                dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
                        'S', 'D' ],
                dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
                        'Qui', 'Sex', 'Sáb', 'Dom' ],
                monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
                        'Abril', 'Maio', 'Junho', 'Julho',
                        'Agosto', 'Setembro', 'Outubro',
                        'Novembro', 'Dezembro' ],
                monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
                        'Mai', 'Jun', 'Jul', 'Ago', 'Set',
                        'Out', 'Nov', 'Dez' ],
                nextText : 'Próximo',
                prevText : 'Anterior',
                showOtherMonths : true,
                selectOtherMonths : true
            };
            
            $("#data").datepicker(datepickerOptions);
        

            //Adicionando itens a tabela de acordo com a busca
            $("#btnbusca").bind("click", function() {
                event.preventDefault();
                
                var estilo = $("#estilo :selected").val();
                var regiao = $("#regiao :selected").val();
                var estacao = $("#estacao :selected").val();
                var data = $("#data").val();
               
                if(!data)
                    data = new Date().getDate().toString();
                var opt = "";
                if($("#dia").is(':checked'))
                    opt = "dia";
                if($("#mes").is(':checked'))
                	opt = "mes";
                if(!estilo)
                    estilo = 0;
                if(!regiao)
                    regiao = 0;
                if(!estacao)
                    estacao = 0;

                
                $.getJSON('<c:url value="/top10/musicasjson/" />' +data+'/'+opt+'/'+estilo+'/'+regiao+'/'+estacao, function(json){
                      console.log("json:",json);
                      
                      $("#tabelatop10 tbody tr").remove();
											
					$.each(json, function() {
						var line = "";
						  $.each(this, function(name, value) {
							  	if(name == "nome"){
								  	line += "<tr><td>" + value + "</td>";
								}else if(name == "artista"){
								 	line += "<td>" + value + "</td>";
								}else if (name == "estilo"){
									line += "<td>" + value.nome + "</td></tr>";
									var $include = line;
									$('#tabelatop10').append($include);
									line = "";
								}
						  });
					});

                  
                });
    
            });

        });
        
    </script>
</div>