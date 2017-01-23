<?php
//KyrgyzsntanProduct.php
include_once('FormatHelper.php');
include_once('Product.php');

class BrasilProduct implements Product {
	private $mfgProduct;
	private $formatHelper;

	public function getProperties(){
			$this->mfgProduct=<<<BRASIL
			<!doctype html><html><head>
			<link rel='stylesheet' type='text/css' href='products.css'/>
			<meta charset='UTF-8'>
			<title> Map Factory </title>
			</head>
			<body> 
				<img src='Mali.png' class='pixRight' width='600' height='304'>
				<header> KYRGYZSTAN </header>
				<p>Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum
			Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum.
			</p>

			</body></html>

BRASIL;

			return $this->mfgProduct;
	}
}
?>