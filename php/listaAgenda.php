<?php
//http://localhost/aneh/rest/listaAgenda.php?uid=Request_ID
 include_once('connection.php');
 
 $uid = isset($_GET['uid']) ? mysql_real_escape_string($_GET['uid']) :  "";
 if(!empty($uid)){
 $qur = mysql_query("select a.nome_aluno, d.dia, d.hora, s.nome_servico, cs.nome_cat from tbl_agendamento as ag 
 					left outer join tbl_aluno as a on a.codigo = ag.cod_aluno
					left outer join tbl_servico as s on ag.cod_servico = s.codigo 
					left outer join tbl_cat_servico as cs on cs.codigo = s.tipo_cat
					left outer join tbl_disponibilidade as d on d.codigo = ag.cod_dia where a.cpf_aluno =='$uid'");
 $result =array();
 while($r = mysql_fetch_array($qur)){
 extract($r);
 $result[] = array("nome_aluno" => $nome_aluno, "dia" => $dia, 'hora' => $hora, 'nome_servico' => $nome_servico, 'nome_cat' => $nome_cat); 
 }
 $json = array("agendamentos" => $result);
 @mysql_close($conn);
 
 /* Output header */
 header('Content-type: application/json');
 echo json_encode($json);	