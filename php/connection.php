<?php

//$conn = false;

//	function getConnection(){
//		global $conn;
//		if ($conn)
//			return $conn;
//		$conn = mysql_connect("179.188.16.12", "sisagenda", "s1s4g3nd4") or die ("Não foi possível conectar ao servidor.");	
//		mysql_select_db('sisagenda', $conn) or die ("Não foi possível selecionar o banco de dados.");
//		return $conn;
//	}

//	function closeConnnection(){
//		global $conn;
//		if($conn != false)
//			mysql_close($conn);
//		$conn = false;
//	}


$conn = mysql_connect("sisagenda.mysql.dbaas.com.br", "sisagenda", "s1s4g3nd4") or die ("Não foi possível conectar ao servidor.");
mysql_select_db('sisagenda', $conn) or die ("Não foi possível selecionar o banco de dados.");