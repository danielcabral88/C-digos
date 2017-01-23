<?php include 'cabecalho2.php';

 ?>


  <div class="row">
                    <div class="col-lg-12">


                        <h1 class="page-header">
                           Medicamentos
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                      <br>
                            <form class="col-lg-9"  action="CRUD/add-medico.php" method="post">
                                    <label for="pacient-name">Nome do Medico</label>
                                    <br>
                                    <input class="form-control" type="text" id="medico" name="medico">
                                      <br>
                                      <label for="pacient-name">CRM</label>
                                    <br>
                                    <input class="form-control" type="text" id="medico" name="crm">
                                      <br>
                                      <label for="pacient-name">Senha</label>
                                    <br>
                                    <input class="form-control" type="password" id="medico" name="senha">
                                      <br>
                                      <button type="submit" class="btn btn-lg btn-primary" >Salvar Cadastro</button>
                                
                               
                                


                            </form>

                        </div>


 <?php include 'rodape.php'; ?>