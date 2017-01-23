<?php include("cabecalho.php");
  include ("conecta.php");
        include ("DAO/DAO-exame.php");?>

  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Exames
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="active"><a href="#novo-Exame" role="tab" data-toggle="tab">Cadastrar Exame</a></li>
                      <li><a href="#lista-Exames" role="tab" data-toggle="tab">Listar Exames</a></li>
                    </ul>
                    
                    <div class="tab-content">
                        <div class="tab-pane col-lg-6 active" id="novo-Exame">
                           <br>
                            <form class = "col-lg-9" action="CRUD/add-exame.php" method="get">

                                <div class="form-group" >
                                    <label for="pacient-name">Nome do Exame</label>
                                    <input class="form-control" type="text" id="nome-exame" name="exame">
                                    <br>
                                  <button type="submit" class="btn btn-lg btn-primary">Salvar Exame</button>
                              
                                </div>
                            </form>

                        </div>
                        <div class="tab-pane col-lg-6" id="lista-Exames">
                         
                            <div class="tab-pane col-lg-12 principal">
                                    <br>
                                    <br>
                           <table class="table table-striped table-bordered">
                                <tr>
                                      <th>Exames</th>
                                      <th>Remover</th>
                                 </tr>

                                <?php
                                    $exames = ListaExame($conexao);
                                    foreach($exames as $exame) :
                                ?>
                                <tr>
                                    <td><?= $exame['nome_exame'] ?></td>
                                    <td >
                                        <form action="CRUD\remover-exame.php" method="post">
                                            <input type="hidden" name="id" value="<?=$medicam['idExame']?>">
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