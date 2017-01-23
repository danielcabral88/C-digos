<?php include("cabecalho.php"); 
        include("conecta.php");
        include("DAO\DAO-PlanoSaude.php");?>


                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Pacientes
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.php">Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-medkit"></i> Pacientes
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="active"><a href="#novo-paciente" role="tab" data-toggle="tab">Cadastrar Paciente</a></li>
                      <li><a href="#lista-paciente" role="tab" data-toggle="tab">Listar Pacientes</a></li>
                    </ul>
                    
                      
                    <div class="tab-content">
                        <div class="tab-pane col-lg-12 active" id="novo-paciente">
                            
                             <form action="CRUD/add-paciente.php" method="get">

                                    <div class="col-lg-6">
                                    <div class="page-header">
                                        <h3>Dados Paciente</h3>
                                    </div>
                                   
                                        <div class="form-group">
                                            <label for="pacient-name">Nome do Paciente</label>
                                            <input class="form-control" name="paciente" type="text">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Nome dos Pais</label>
                                            <input type="text" class="form-control" name="nomemae" placeholder="Nome da Mãe"><br>
                                            <input type="text" class="form-control" name="nomepai" placeholder="Nome do Pai">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Data de Nascimento</label>
                                            <input type="date" name="datanascimento" class="form-control">
                                        </div>
                                        
                                      
                                  

                                     <div class="page-header">
                                        <h3>Telefones</h3>
                                    </div>
                                    
                                        <div class="form-group">
                                            <label  for="pacient-name" id="celular">Telefone Celular</label>
                                            <input class="form-control" type="text" name="dddcelular" placeholder="DDD" id="ddd-celular"><br>

                                            <input  class="form-control" type="text" name="numerocelular" placeholder="número" id="numero-celular">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="">Complemento</label>
                                            <input type="text" class="form-control" name="complementocelular" id="complemento-celular">
                                        </div>
                                        <br>

                                        
                                        <div class="form-group">
                                            <label  for="pacient-name" id="telefone-fixo">Telefone Residencial</label>
                                            <input class="form-control" type="text" placeholder="DDD" name="dddfixo" id="ddd-telefone"><br>

                                            <input  class="form-control" type="text" placeholder="número" name="numerofixo" id="numero-telefone">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="">Complemento</label>
                                            <input type="text" class="form-control" name="complementofixo" id="complemento-residencial">
                                        </div>
                                        
                                    
                                    </div>
                                    <div class="col-lg-6">
                                    <div class="page-header">
                                        <h3>Endereco</h3>
                                    </div>
                                    
                                          
                                        <div class="form-group controls">
                                            <label for="">Logradouro</label>
                                            <input type="text" class="form-control" id ="logradouro" name="logradouro">
                                      </div>
                                      <div class="form-group">
                                            <label for="">Numero</label>
                                            <input type="number" class="form-control" id="numero" name="numero">
                                      </div>
                                      <div class="form-group">
                                            <label for="">Complemento</label>
                                            <input type="text" class="form-control" id="complemento" name="complemento">
                                      </div>
                                      <div class="form-group">
                                            <label for="">Bairro</label>
                                            <input type="text" class="form-control" id="bairro" name="bairro">
                                      </div>
                                      
                                      <div class="form-group">
                                            <label for="">Municipio</label>
                                            <input type="text" class="form-control" id="municipio" name="municipio">
                                      </div>

                                     <div class="form-group">
                                            <label for="">Cep </label>
                                            <input type="text" class="form-control" id="cep" name="cep">
                                    </div>
                                        <div class="form-group">
                                            <label for="">UF</label>
                                            <input type="text" class="form-control" id="uf" name="uf">
                                            </div>
                                  
                                        
                                    

                                    <div class="page-header">
                                        <h3>Plano de Saúde</h3>
                                    </div>
                                   
                                          
                                        <div class="form-group controls">
                                            <label for="">Selecione seu plano de saúde</label>
                                                <input  class="form-control" type="text" name="planosaude" id="srch" list="datalist1" />
                                                    <datalist id="datalist1">
                                                    
                                                        <?php
                                                        $planos = ListaPlano($conexao);
                                                        foreach($planos as $plano) :
                                                        ?>
                                                    <option value="<?= $plano['nome_plano'] ?>"> 
                                                      <?php    endforeach ?>
                                                    </datalist>
                                             
                                      </div>
                                        <br>
                                        <br>
                                    <button type="submit" class="btn btn-lg btn-primary">Salvar Paciente</button>

                                </div>
                            </form>
                        </div>

                        <div class="tab-pane col-lg-6" id="lista-paciente">
                            EM CONSTRUÇÃO
                        </div>
                    </div>
              

        </div>

<?php include("rodape.php") ?>