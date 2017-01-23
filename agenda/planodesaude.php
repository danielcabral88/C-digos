<?php include("cabecalho.php");
  include ("conecta.php");
        include ("DAO/DAO-PlanoSaude.php"); ?>

  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Plano de Saúde
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="active"><a href="#novoPlano" role="tab" data-toggle="tab">Cadastrar Plano de Saúde</a></li>
                      <li><a href="#lista-Planos" role="tab" data-toggle="tab">Listar Planos cadastrados</a></li>
                    </ul>
                    
                    <div class="tab-content">
                        <div class="tab-pane col-lg-6 active" id="novoPlano">
                           <br>
                            <form class = "col-lg-9" action="CRUD/add-Plano.php">

                                <div class="form-group">
                                    <label for="pacient-name">Nome do Plano de Saúde</label>
                                    <input class="form-control" type="text" id="plano" name="plano">
                                    <button type="submit" class="btn btn-lg btn-primary">Salvar Plano</button>
                                </div>
                            </form>

                            
                        </div>
                        <div class="tab-pane col-lg-6" id="lista-Planos">
                            

                            <div class="tab-pane col-lg-12 principal">
                                    <br>
                                    <br>
                           <table class="table table-striped table-bordered">
                                <tr>
                                      <th>Planos</th>
                                      <th>Remover</th>
                                 </tr>

                                <?php
                                    $planos = ListaPlano($conexao);
                                    foreach($planos as $plano) :
                                ?>
                                <tr>
                                    <td><?= $plano['nome_plano'] ?></td>
                                    <td >
                                        <form action="CRUD/remover-plano.php" method="post">
                                            <input type="hidden" name="id" value="<?=$medicam['idPlanoSaude']?>">
                                            <button class="btn btn-danger">remover</button>
                                        </form>
                                      </td>
                                </tr>
                                <?php
                                endforeach
                                ?>
                           </table>
                        </div>
                        </div>
                    </div>
                    
                </div>
                <!-- /.row -->



<?php include("rodape.php") ?>